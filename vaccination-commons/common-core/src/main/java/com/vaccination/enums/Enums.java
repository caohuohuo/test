package com.vaccination.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wei.wang
 * @Package com.hcmis.loan.core.enums
 * @Description:
 * @date 2021/4/22 09:37
 */
public class Enums {
    /**
     * 数据库删除状态
     */
    public enum DeletedEnums {
        YES(1, "未删除"),
        NO(2, "已删除");
        private Integer value;
        private String msg;

        private DeletedEnums(Integer value, String msg) {
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
            for (DeletedEnums a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }

    /**
     * 身份证正面反面
     */
    public enum IdcardEnums {
        FRONT("front", "正面"),
        BACK("back", "反面");
        private String value;
        private String msg;

        private IdcardEnums(String value, String msg) {
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
            for (IdcardEnums a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }

    /**
     * 判断枚举
     */
    public enum JudgeEnum {
        YES(1, "是"),
        NO(2, "否");
        @Getter
        private Integer value;
        @Getter
        private String label;

        JudgeEnum(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();

        static {
            JSONObject tmp;
            for (JudgeEnum item : JudgeEnum.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
            }
        }
    }

    /**
     * 产品审核状态
     */
    public enum ProductAuditEnums {
        PASS(1, "通过"),
        REFUSE(2, "拒绝"),
        BACK(3, "退回");
        @Getter
        private Integer value;
        @Getter
        private String label;

        private ProductAuditEnums(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public static String getMessage(String val) {
            for (ProductAuditEnums a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getLabel();
                }
            }
            return null;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();

        static {
            JSONObject tmp;
            for (ProductAuditEnums item : ProductAuditEnums.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
            }
        }
    }

    /**
     * 订单审核状态
     */
    public enum OrderAuditEnums {
        PASS(1, "通过"),
        REFUSE(2, "终止");
        @Getter
        private Integer value;
        @Getter
        private String label;

        private OrderAuditEnums(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public static String getMessage(String val) {
            for (OrderAuditEnums a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getLabel();
                }
            }
            return null;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();

        static {
            JSONObject tmp;
            for (OrderAuditEnums item : OrderAuditEnums.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
            }
        }
    }
}
