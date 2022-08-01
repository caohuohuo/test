package com.vaccination.enums;

import lombok.Getter;

/**
 * 用户类型枚举
 */
public enum UserTypeEnum {
    /**
     * 用户类型-客户
     */
    CSR("1", "客户"),

    SYS("2", "系统用户");

    @Getter
    private String code;
    @Getter
    private String msg;

    UserTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
