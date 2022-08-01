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
public enum FinanceOrgTypeEnum {

    BANK(1,"银行"),
    CONSUMER_FINANCE(2, "消金公司"),
    INSURANCE(3, "保险"),
    TRUST(4, "信托"),
    FACTORING(5, "保理"),
    BROKER(6, "券商"),
    FUND(7, "基金"),
    PRIVATE_INVESTMENT_INSTITUTIONS(8, "民间投资机构"),
    OTHER(9, "其他");

    private static Map<Integer, String> map = new HashMap<>();

    private Integer value;
    private String msg;

    private FinanceOrgTypeEnum(Integer value, String msg) {
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
        for (FinanceOrgTypeEnum a : values()) {
            if (a.getValue().equals(val)) {
                return a.getMsg();
            }
        }
        return null;
    }

    private static final JSONArray VALUE_ARR = new JSONArray();

    static {
        JSONObject tmp;
        for (FinanceOrgTypeEnum item : FinanceOrgTypeEnum.values()) {
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
