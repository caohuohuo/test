package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author wei.wang
 * @Package com.hcmis.loan.core.enums
 * @Description:
 * @date 2021/5/11 16:24
 */
public enum BusinessConfEnum {
    isIntercept(1, "是否系统按产品准入做提交拦截"),
    isApproveFinance(2, "是否需要平台人员审批融资产品"),
    isApproveInvestment(3, "是否需要平台人员审批投资理财产品"),
    isApproveApply(4, "是否需要平台人员审核融资申请"),
    isInvestApply(5, "是否需要平台人员审核投资理财产品申请"),
    isRisk(6, "是否开启风险预警功能");
    private Integer value;
    private String msg;

    private BusinessConfEnum(Integer value, String msg) {
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
        for (BusinessConfEnum a : values()) {
            if (a.getValue().equals(val)) {
                return a.getMsg();
            }
        }
        return null;
    }

    private static final JSONArray VALUE_ARR = new JSONArray();

    static {
        JSONObject tmp;
        for (BusinessConfEnum item : BusinessConfEnum.values()) {
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
