package com.vaccination.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableDefaultOrderBy
 * 6/30/21
 *
 * @Author xiaoguang
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DefaultOrderByConfiguration.class)
@Documented
public @interface EnableDefaultOrderBy {

}
