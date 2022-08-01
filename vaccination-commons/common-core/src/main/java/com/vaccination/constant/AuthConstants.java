package com.vaccination.constant;

public interface AuthConstants {


    /**
     * 认证请求头key
     */
    String AUTHORIZATION_KEY = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_PREFIX = "Bearer ";


    /**
     * Basic认证前缀
     */
    String BASIC_PREFIX = "Basic ";

    /**
     * JWT载体key
     */
    String JWT_PAYLOAD_KEY = "payload";

    /**
     * Redis缓存权限规则key
     */
    String PERMISSION_ROLES_KEY = "auth:permission:roles";

    /**
     * user_id
     */
    String JWT_USER_ID_KEY = "user_id";

    String JWT_USERNAME_KEY = "username";

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";


    /**
     * 用户正常
     */
    Integer STSTUS_NORMAL_USER = 1;

    /**
     * 用户冻结
     */
    Integer STSTUS_FROZEN_USER = 2;

    /**
     * 用户默认角色
     */
    String DEFAULT_ROLE = "ROLE_USER";

    /**
     * 用户登录角色
     */
    String LOGIN_ROLE = "ROLE_LOGIN";

}
