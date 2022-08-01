package com.vaccination.enums;

import lombok.Getter;

/**
 * 新闻类型枚举
 */
public enum NewsTypeEnum {
    /**
     * 新闻
     */
    HOME_CAROUSEL(3, "首页轮播图"),

    FINANCE_CAROUSEL(4, "理财轮播图"),

    NEWS_INFO(1, "新闻资讯"),

    POLICY_INFO(2, "政策资讯");

    @Getter
    private Integer code;
    @Getter
    private String msg;

    NewsTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
