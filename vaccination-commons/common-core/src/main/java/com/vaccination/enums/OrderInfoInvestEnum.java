package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 投资理财记录相关状态
 */
public class OrderInfoInvestEnum {
    /**
     * 订单状态
     */
    public enum OrderStatus {
        WAIT_AUDIT(100, "待审核", "金融机构处理中"),
        WAIT_PROCESS(200, "待处理", "金融机构处理中"),
        PROCESSED(300, "已处理", "金融机构已处理"),
        SUSPEND(400, "终止", "终止");

        private static Map<Integer, OrderStatus> map = new HashMap<>();
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

        private static String getLabel(OrderStatus orderStatus) {
            if (orderStatus == null) {
                return null;
            }
            return orderStatus.getLabel();
        }

        private static String getClientLabel(OrderStatus orderStatus) {
            if (orderStatus == null) {
                return null;
            }
            return orderStatus.getClientLabel();
        }

        static {
            JSONObject tmp;
            for (OrderStatus item : OrderStatus.values()) {
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
            for (OrderStatusClient item : OrderStatusClient.values()) {
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
}
