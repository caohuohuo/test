package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目融资相关枚举
 */
public class OrderProjectInfoEnum {
    /**
     * 订单状态
     */
    public enum OrderStatus {
        WAIT_AUDIT(100, "待审核", "金融机构处理中"),
        WAIT_PROCESS(200, "待处理", "金融机构处理中"),
        PROCESSED(300, "已处理", "金融机构已处理"),
        SUSPEND(400, "终止", "终止");

        private static Map<Integer, com.vaccination.enums.OrderInfoInvestEnum.OrderStatus> map = new HashMap<>();
        @Getter
        private Integer value;
        @Getter
        private String label;
        @Getter
        private String clientLabel;

        private OrderStatus(Integer value, String label, String clientLabel) {
            this.value = value;
            this.label = label;
            this.clientLabel = clientLabel;
        }

        public static String getLabel(Integer val) {
            return getLabel(map.get(val));
        }

        public static String getClientLabel(Integer val) {
            return getClientLabel(map.get(val));
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        private static String getLabel(com.vaccination.enums.OrderInfoInvestEnum.OrderStatus orderStatus) {
            if (orderStatus == null) {
                return null;
            }
            return orderStatus.getLabel();
        }

        private static String getClientLabel(com.vaccination.enums.OrderInfoInvestEnum.OrderStatus orderStatus) {
            if (orderStatus == null) {
                return null;
            }
            return orderStatus.getClientLabel();
        }

        static {
            JSONObject tmp;
            for (com.vaccination.enums.OrderInfoInvestEnum.OrderStatus item : com.vaccination.enums.OrderInfoInvestEnum.OrderStatus.values()) {
                map.put(item.getValue(), item);
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                VALUE_ARR.add(tmp);
            }
        }

        public static JSONArray getValueArr() {
            return VALUE_ARR;
        }
    }

    /**
     * 订单状态
     */
    public enum OrderStatusClient {
        PENDING("100,200", "金融机构处理中"),
        PROCESSED("300", "金融机构已处理"),
        SUSPEND("400", "终止");

        private static Map<String, String> map = new HashMap<>();
        @Getter
        private String value;
        @Getter
        private String label;

        OrderStatusClient(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public static String getLabel(String val) {
            return map.get(val);
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (com.vaccination.enums.OrderInfoInvestEnum.OrderStatusClient item : com.vaccination.enums.OrderInfoInvestEnum.OrderStatusClient.values()) {
                map.put(item.getValue(), item.getLabel());
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                VALUE_ARR.add(tmp);
            }
        }

        public static JSONArray getValueArr() {
            return VALUE_ARR;
        }
    }

    /**
     * 融资轮次
     */
    public enum FinanceRound {
        SEED("种子轮"),
        ANGEL("天使轮"),
        PRE_A("Pre-A轮"),
        A("A轮"),
        A_PLUS("A+"),
        B("B轮"),
        B_PLUS("B+"),
        C("C轮"),
        C_PLUS("C+"),
        D("D轮"),
        D_PLUS("D+"),
        E("E轮"),
        E_PLUS("E+"),
        F("F轮"),
        F_PLUS("F+"),
        STRATEGY("战略融资"),
        RRE_IPO("PreIPO"),
        IPO("IPO"),
        OTHER("其他");

        private static Map<String, FinanceRound> map = new HashMap<>();
        @Getter
        private String label;

        FinanceRound(String label) {
            this.label = label;
        }

        public static String getLabel(String val) {
            return getLabel(map.get(val));
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        private static String getLabel(FinanceRound financeRound) {
            if (financeRound == null) {
                return null;
            }
            return financeRound.getLabel();
        }

        static {
            JSONObject tmp;
            for (FinanceRound item : FinanceRound.values()) {
                map.put(item.name(), item);
                tmp = new JSONObject();
                tmp.put("label", item.getLabel());
                tmp.put("value", item.name());
                VALUE_ARR.add(tmp);
            }
        }

        public static JSONArray getValueArr() {
            return VALUE_ARR;
        }
    }

    /**
     * 必传材料
     */
    public enum NecessaryData {
        PROSPECTUS("商业/项目计划书"),
        CERTIFICATE("公司证件"),
        FINANCIAL_DATA("相关财务数据"),
        ROADSHOW_PPT("路演PPT");

        private static Map<String, NecessaryData> map = new HashMap<>();
        private static final JSONArray VALUE_ARR = new JSONArray();

        @Getter
        private String label;

        NecessaryData(String label) {
            this.label = label;
        }

        public static String getLabel(String val) {
            return getLabel(map.get(val));
        }

        private static String getLabel(NecessaryData necessaryData) {
            if (necessaryData == null) {
                return null;
            }
            return necessaryData.getLabel();
        }

        static {
            JSONObject tmp;
            for (NecessaryData item : NecessaryData.values()) {
                map.put(item.name(), item);
                tmp = new JSONObject();
                tmp.put("label", item.getLabel());
                tmp.put("value", item.name());
                VALUE_ARR.add(tmp);
            }
        }

        public static JSONArray getValueArr() {
            return VALUE_ARR;
        }
    }
}
