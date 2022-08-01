package com.vaccination.annotation;

import java.lang.annotation.*;

/**
 * OrderInterceptorIgnore
 * 7/6/21
 *
 * @Author xiaoguang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderInterceptorIgnore {
}
