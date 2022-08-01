package com.vaccination.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wei.wang
 * @Package com.hcmis.loan.core.enums
 * @Description: ${TODO}
 * @date 2021/4/20 12:44
 */
public class ProductInvestEnum {

    /**
     * 基金类别
     */
    public enum ProductCategory {
        /**
         * 基金
         */
        CURRENCY(1, "货币基金"),
        SHARES(2, "股票基金"),
        BOND(3, "债券基金"),
        MIXED(4, "混合基金"),
        /**
         * 理财
         */
        FIXED(5, "固收类"),
        CASH(6, "现金类"),
        OTHER(7, "混合及其他");
        @Getter
        private Integer value;
        @Getter
        private String label;

        ProductCategory(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<Integer, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (ProductCategory item : ProductCategory.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(Integer value) {
            return map.get(value);
        }
    }

    /**
     * 基金类别
     */
    public enum FundCategory {
        CURRENCY(1, "货币基金"),
        SHARES(2, "股票基金"),
        BOND(3, "债券基金"),
        MIXED(4, "混合基金");
        @Getter
        private Integer value;
        @Getter
        private String label;

        FundCategory(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<Integer, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (FundCategory item : FundCategory.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(Integer value) {
            return map.get(value);
        }
    }

    /**
     * 基金类别
     */
    public enum FinanceCategory {
        FIXED(5, "固收类"),
        CASH(6, "现金类"),
        OTHER(7, "混合及其他");
        @Getter
        private Integer value;
        @Getter
        private String label;

        FinanceCategory(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<Integer, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (FinanceCategory item : FinanceCategory.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(Integer value) {
            return map.get(value);
        }
    }

    /**
     * 风险等级
     */
    public enum RiskLevel {
        R1(1, "R1低风险"),
        R2(2, "R2中低风险"),
        R3(3, "R3中风险"),
        R4(4, "R4中高风险"),
        R5(5, "R5高风险");
        @Getter
        private Integer value;
        @Getter
        private String label;

        RiskLevel(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<Integer, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (RiskLevel item : RiskLevel.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(Integer value) {
            return map.get(value);
        }
    }

    /**
     * 风险等级
     */
    public enum Performance {
        SEV_DAY(1, "七日年化收益"),
        ONE_MONTH(2, "近一个月涨幅"),
        ONE_YEAR(3, "近一年收益率"),
        THREE_YEAR(4, "近三年收益率"),
        SINCE(5, "成立以来年化"),
        BENCHMARK(6, "业绩比较基准");

        @Getter
        private Integer value;
        @Getter
        private String label;

        Performance(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<Integer, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (Performance item : Performance.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(Integer value) {
            return map.get(value);
        }
    }
}
