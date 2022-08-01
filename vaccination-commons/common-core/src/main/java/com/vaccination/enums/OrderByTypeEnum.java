package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * OrderByTypeEnum
 * 5/11/21
 *
 * @Author xiaoguang
 */
public enum OrderByTypeEnum {

    DEFAULT("default", "默认排序"),
    PROCOUNT("procount", "产品数量"),
    FINSUM("finsum", "放款金额");

    private String value;
    private String msg;

    OrderByTypeEnum(String value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    public String getValue() {
        return this.value;
    }

    public String getMsg() {
        return this.msg;
    }

    public static String getMessage(String val) {
        for (OrderByTypeEnum a : values()) {
            if (a.getValue().equals(val)) {
                return a.getMsg();
            }
        }
        return null;
    }

    public static String getKey(String val) {
        for (OrderByTypeEnum a : values()) {
            if (a.getMsg().equals(val)) {
                return a.getValue();
            }
        }
        return null;
    }

    private static final JSONArray VALUE_ARR = new JSONArray();

    static {
        JSONObject tmp;
        for (OrderByTypeEnum item : OrderByTypeEnum.values()) {
            tmp = new JSONObject();
            tmp.put("value", item.getValue());
            tmp.put("label", item.getMsg());
            VALUE_ARR.add(tmp);
        }
    }

    public static JSONArray getValueArr() {
        return VALUE_ARR;
    }
}
