package com.vaccination.constant;

public interface RedisConstants {

    String WHITELIST = "login:ip:";

//    login:token:客户端/企业端:手机号:role:ip
    String REDIS_TOKEN = "login:token:%s:%s:%s:%s";

    /**
     * 手机号限制
     */
    String LIMIT_MOBILE = "limit:mobile:";

    Long EXP_LIMIT_MOBILE = 60L;

    /**
     * IP限制
     */
    String LIMIT_IP = "limit:ip:";

    Long EXP_LIMIT_IP = 60 * 60L;
}
