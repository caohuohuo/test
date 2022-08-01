package com.vaccination.config;


import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.vaccination.handler.CustomMetaObjectHandler;
import com.vaccination.interceptor.OrderByInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 排序插件
     */
    @Bean
    @ConditionalOnBean(DefaultOrderByConfiguration.Marker.class)
    public OrderByInterceptor orderByInterceptor() {
        return new OrderByInterceptor();
    }


    /**
     * 自动填充数据库创建人、创建时间、更新人、更新时间
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new CustomMetaObjectHandler());
        return globalConfig;
    }

}
