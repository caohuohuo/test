package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据权限枚举
 */
public enum DataPermEnum {
    /**
     * 数据权限-所属机构
     */
    PERM_ORG("1", "所属机构"),
    PERM_ALL("2", "所有数据"),
    PERM_SELF("3", "绑定数据");

    private static Map<String, DataPermEnum> map = new HashMap<>();

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String msg;

    static {
        for (DataPermEnum item : DataPermEnum.values()) {
            map.put(item.getCode(), item);
        }
    }


    DataPermEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static DataPermEnum getValue(String code) {
        return map.get(code);
    }

    public static String getMsg(String code) {
        return map.get(code).getMsg();
    }


    private static final JSONArray VALUE_ARR = new JSONArray();

    static {
        JSONObject tmp;
        for (DataPermEnum item : DataPermEnum.values()) {
            tmp = new JSONObject();
            tmp.put("value", item.getCode());
            tmp.put("label", item.getMsg());
            VALUE_ARR.add(tmp);
        }
    }

    public static JSONArray getValueArr() {
        return VALUE_ARR;
    }
}
