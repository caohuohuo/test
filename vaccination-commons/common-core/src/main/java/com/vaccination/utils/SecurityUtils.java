/**
 * Copyright (C) 2018-2020
 * All rights reserved, Designed By www.yixiang.co
 * 注意：
 * 本软件为www.yixiang.co开发研制
 */
package com.vaccination.utils;

import cn.hutool.json.JSONObject;
import com.vaccination.constant.ClientConstants;
import com.vaccination.enums.DataPermEnum;
import com.vaccination.enums.UserTypeEnum;
import com.vaccination.exception.LoginStatusException;
import com.vaccination.result.ResultCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


/**
 * 获取当前登录的用户
 *
 * @author Zheng Jie
 * @date 2019-01-17
 */
public class SecurityUtils {

    public static UserDetails getUserDetails() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new LoginStatusException(ResultCode.USER_NOT_EXIST);
        }
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            UserDetailsService userDetailsService = SpringContextUtils.getBean(UserDetailsService.class);
            return userDetailsService.loadUserByUsername(userDetails.getUsername());
        }
        throw new LoginStatusException(ResultCode.USER_NOT_EXIST);
    }

    /**
     * 获取用户类型
     *
     * @return 1-客户，2-客户经理
     */
    public static UserTypeEnum getUserType() {
        try {
            Object obj = getUserDetails();
            JSONObject json = new JSONObject(obj);
            String userType = json.getStr("userType");
            if (UserTypeEnum.CSR.getCode().equals(userType)) {
                return UserTypeEnum.CSR;
            } else if (UserTypeEnum.SYS.getCode().equals(userType)) {
                return UserTypeEnum.SYS;
            }
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * 获取系统用户名称
     *
     * @return 系统用户名称
     */
    public static String getUsername() {
        try {
            Object obj = getUserDetails();
            JSONObject json = new JSONObject(obj);
            return json.get("username", String.class);
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取系统用户名称
     *
     * @return 系统用户名称
     */
    public static String getNikename() {
        try {
            Object obj = getUserDetails();
            JSONObject json = new JSONObject(obj);
            return json.get("nikename", String.class);
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取系统用户id
     *
     * @return 系统用户id
     */
    public static Integer getUserId() {
        try {
            Object obj = getUserDetails();
            JSONObject json = new JSONObject(obj);
            return json.getInt("id");
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取系统用户id
     *
     * @return 系统用户id
     */
    public static Integer getUserIdDefaultNull(HttpServletRequest request) {
        try {
            JSONObject json = new JSONObject(request.getSession().getAttribute("SPRING_SECURITY_CONTEXT"));
            json = json.getJSONObject("authentication");
            if (json != null) {
                json = json.getJSONObject("principal");
                return json.getInt("id");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取系统用户id
     *
     * @return 系统用户id
     */
    public static Integer getOrgId() {
        try {
            Object obj = getUserDetails();
            JSONObject json = new JSONObject(obj);
            return json.getInt("orgId");
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取系统用户id
     *
     * @return 系统用户id
     */
    public static String getOrgName() {
        try {
            Object obj = getUserDetails();
            JSONObject json = new JSONObject(obj);
            return json.getStr("orgName");
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取系统客户端id
     *
     * @return 系统用户id
     */
    public static String getClientId() {
        try {
            return SpringContextUtils.getBean("profileService") != null ?
                    ClientConstants.CLIENT_ADMIN : ClientConstants.CLIENT_WEB;
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return ClientConstants.CLIENT_WEB;
        }
    }

    /**
     * 获取系统用户id
     *
     * @return 系统用户id
     */
    public static Collection<? extends GrantedAuthority> getAuthorities() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new LoginStatusException(ResultCode.USER_NOT_EXIST);
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getAuthorities();
    }

    public static DataPermEnum getDataPerm() {
        try {
            Object obj = getUserDetails();
            JSONObject json = new JSONObject(obj);
            return DataPermEnum.getValue(json.getStr("dataPrivilege"));
        } catch (UsernameNotFoundException e) {
            throw new LoginStatusException("用户不存在");
        } catch (Exception e) {
            return null;
        }

    }
}
