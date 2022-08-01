package com.vaccination.interceptor;

import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.handlers.AbstractSqlParserHandler;
import com.vaccination.annotation.OrderInterceptorIgnore;
import com.vaccination.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * OrderByInterceptor
 * 6/30/21
 *
 * @Author xiaoguang
 */
@Slf4j
@AllArgsConstructor
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class OrderByInterceptor extends AbstractSqlParserHandler implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        this.sqlParser(metaObject);
        // 先判断是不是SELECT操作 不是直接过滤
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if (!SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
            return invocation.proceed();
        }


        final Object[] args = invocation.getArgs();
        //获取执行方法的位置
        String namespace = mappedStatement.getId();
        //获取mapper名称
        String className = namespace.substring(0,namespace.lastIndexOf("."));
        //获取方法名
        String methedName= namespace.substring(namespace.lastIndexOf(".") + 1,namespace.length());
        //获取当前mapper 的方法
        Method[] ms = Class.forName(className).getMethods();
        for(Method m : ms){
            if(m.getName().equals(methedName)){
                OrderInterceptorIgnore annotation = m.getAnnotation(OrderInterceptorIgnore.class);
                if(annotation != null){
                    return invocation.proceed();
                }
            }
        }


        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        // 执行的SQL语句
        String originalSql = boundSql.getSql();


        //处理排序
        originalSql.replaceAll("order by", "ORDER BY");
        if (originalSql.contains("ORDER BY")) {
            originalSql = originalSql.substring(0, originalSql.indexOf("ORDER BY"));


        }

        //没有update_time字段直接不处理
        if (!originalSql.contains("update_time")) {
            return invocation.proceed();
        }

        originalSql = "select * from (" + originalSql + ") temp_data_scope  order by temp_data_scope.update_time desc";

        HttpServletRequest request = getRequest();
        String orderField = request.getParameter("orderField");
        String orderType = request.getParameter("orderType");

        if (!StringUtils.isEmpty(orderField) && !StringUtils.isEmpty(orderType)) {
            orderField = orderField.replaceAll("Label", "");
            orderType = orderType.replaceAll("ascend", "asc").replaceAll("descend", "desc");
            if (originalSql.contains(humpToLine(orderField))) {
                switch (orderField) {

                    case "platformStatus":
                        originalSql = "select * from (" + originalSql + ") temp_data_scope  order by  FIELD(temp_data_scope." + humpToLine(orderField) + ", '1','2','4','3','5')  " + orderType + ", temp_data_scope.update_time desc";
                        break;

                    case "orderStatus":
                        originalSql = "select * from (" + originalSql + ") temp_data_scope  order by  FIELD(temp_data_scope." + humpToLine(orderField) + ", '100','110','200','300','400','500','600','800','900','700')  " + orderType + ", temp_data_scope.update_time desc";
                        break;

                    default:
                        originalSql = "select * from (" + originalSql + ") temp_data_scope  order by  temp_data_scope." + humpToLine(orderField) + " " + orderType + ", temp_data_scope.update_time desc";
                }

            }
        }

        metaObject.setValue("delegate.boundSql.sql", originalSql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private static HttpServletRequest getRequest() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder
                        .getRequestAttributes())
                        .getRequest();
        return request;
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线,效率比上面高
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
