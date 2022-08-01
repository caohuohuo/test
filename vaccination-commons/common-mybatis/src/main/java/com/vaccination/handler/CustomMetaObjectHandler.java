package com.vaccination.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.vaccination.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class CustomMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("creator", SecurityUtils.getUserId(), metaObject);
        this.setFieldValByName("updater", SecurityUtils.getUserId(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updater", SecurityUtils.getUserId(), metaObject);
    }

}
