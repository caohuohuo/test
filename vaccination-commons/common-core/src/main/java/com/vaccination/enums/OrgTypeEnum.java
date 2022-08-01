package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * OrgTypeEnum
 * 5/26/21
 *
 * @Author xiaoguang
 */
public enum OrgTypeEnum {

    FINANCE_ORG(1,"信贷机构"),
    MANAGER_ORG(2, "政府机构"),
    ADMIN_ORG(3, "平台运营机构"),
    VENTURE_ORG(4, "风投机构");

    private static Map<Integer, String> map = new HashMap<>();

    private Integer value;
    private String msg;

    private OrgTypeEnum(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getMsg() {
        return this.msg;
    }

    public static String getMessage(Integer val) {
        for (OrgTypeEnum a : values()) {
            if (a.getValue().equals(val)) {
                return a.getMsg();
            }
        }
        return null;
    }

    private static final JSONArray VALUE_ARR = new JSONArray();

    static {
        JSONObject tmp;
        for (OrgTypeEnum item : OrgTypeEnum.values()) {
            tmp = new JSONObject();
            tmp.put("value", item.getValue());
            tmp.put("label", item.getMsg());
            VALUE_ARR.add(tmp);
            map.put(item.getValue(), item.getMsg());
        }
    }

    public static JSONArray getValueArr() {
        return VALUE_ARR;
    }

    public static String getMsg(Integer value) {
        return map.get(value);
    }
}
