package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei.wang
 * @Package com.hcmis.loan.core.enums
 * @Description: 订单相关状态
 * @date 2021/4/21 18:05
 */
public class OrderInfoEnum {

    /**
     * 订单状态
     */
    public enum OrderStatus {
        DTJ(100, "待客户提交"),
        WAIT_AUDIT(110, "待平台审核"),
        DFPJG(200, "待分配机构"),
        DFPKHJL(300, "待分配客户经理"),
        DJD(400, "待尽调"),
        DEDDJ(500, "待额度登记"),
        SHTG(600, "额度审核通过"),
        SHJJ(700, "额度审核拒绝"),
        EDDQ(800, "额度到期"),
        ZZ(900, "终止");

        private static Map<Integer, String> map = new HashMap<>();

        private Integer value;
        private String msg;

        private OrderStatus(Integer value, String msg) {
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
            for (OrderStatus a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (OrderStatus item : OrderStatus.values()) {
                if (item.getValue()==100){
                    continue;
                }
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

    public enum OrderCsrStatus {
        SHZ(500, "审核中"),
        SHTG(600, "审核通过"),
        SHJJ(700, "审核拒绝"),
        EDDQ(800, "额度到期"),
        ZZ(900, "终止");
        private Integer value;
        private String msg;

        private OrderCsrStatus(Integer value, String msg) {
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
            for (OrderCsrStatus a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (OrderCsrStatus item : OrderCsrStatus.values()) {
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


    public enum OrderManagerStatus {
        DHF(800, "待回访"),
        YHF(900, "已回访");
        private Integer value;
        private String msg;

        private OrderManagerStatus(Integer value, String msg) {
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
            for (OrderManagerStatus a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (OrderManagerStatus item : OrderManagerStatus.values()) {
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

    /**
     * 还款状态枚举
     */
    public enum RepayStatusEnum {
        YES(1, "已还清"),
        NO(2, "未还清");
        @Getter
        private Integer value;
        @Getter
        private String label;

        RepayStatusEnum(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<Integer, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (RepayStatusEnum item : RepayStatusEnum.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                map.put(item.getValue(), item.getLabel());
                valueArr.add(tmp);
            }
        }

        public static String getLabel(Integer value) {
            return map.get(value);
        }
    }
}
