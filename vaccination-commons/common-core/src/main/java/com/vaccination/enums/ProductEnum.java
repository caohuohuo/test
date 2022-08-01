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
 * @Description: ${TODO}
 * @date 2021/4/20 12:44
 */
public class ProductEnum {
    /**
     * 是否认证
     */
    public enum GuaranteeType {
        mortgage("mortgage", "抵押"),
        pledge("pledge", "质押"),
        credit("credit", "信用"),
        guarantee("guarantee", "一般保证");
        private String value;
        private String msg;

        private GuaranteeType(String value, String msg) {
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
            for (GuaranteeType a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        public static String getKey(String val) {
            for (GuaranteeType a : values()) {
                if (a.getMsg().equals(val)) {
                    return a.getValue();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (GuaranteeType item : GuaranteeType.values()) {
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
     * 热推
     */
    public enum HotEnums {
        YES(1, "是"),
        NO(2, "否");
        private Integer value;
        private String msg;

        private HotEnums(Integer value, String msg) {
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
            for (HotEnums a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (HotEnums item : HotEnums.values()) {
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

    public enum RepayType {
        equalPrincipal("equalPrincipal", "等额本金"),
        equalPrincipalInterest("equalPrincipalInterest", "等额本息"),
        interestBeforePrincipal("interestBeforePrincipal", "先息后本"),
        loanReturn("loanReturn", "随借随还"),
        oneTimeRepayment("oneTimeRepayment", "一次性还本付息"),
        other("other", "其他");
        private String value;
        private String msg;

        private RepayType(String value, String msg) {
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
            for (RepayType a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (RepayType item : RepayType.values()) {
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
     * 必传材料
     */
    public enum NecessaryData {
        license("license", "营业执照"),
        taxInformation("taxInformation", "纳税信息"),
        bylaw("bylaw", "公司章程及修正案"),
        verificationReport("verificationReport", "企业验资报告"),
        shareholdersMeeting("shareholdersMeeting", "股东会决议或董事会决议"),
        fddbrfqsfsfzSjkzrfqsfsfz("fddbrfqsfsfz/sjkzrfqsfsfz", "法定代表人夫妻双方身份证正反面/实际控制人夫妻双方身份证正反面"),
        fddbrfqsfsfzSjkzrfqsfsfzq("fddbrfqsfsfz&sjkzrfqsfsfz", "法定代表人夫妻双方身份证正反面&实际控制人夫妻双方身份证正反面"),
        fddbrfqsfjhzSjkzrfqsfjhz("fddbrfqsfjhz/sjkzrfqsfjhz", "法定代表人夫妻双方结婚证/实际控制人夫妻双方结婚证"),
        fddbrfqsfhkbSjkzrfqsfhkb("fddbrfqsfhkb/sjkzrfqsfhkb", "法定代表人夫妻双方户口本/实际控制人夫妻双方户口本"),
        agentIdCard("agentIdCard", "授权办理人身份证正反面"),
        bankAccount("bankAccount", "企业银行账户信息"),
        jycdzlhthfcz("jycdzlhthfcz", "经营场地租赁合同或房产证"),
        jycdzjzfpz("jycdzjzfpz", "经营场地租金支付凭证"),
        creditReport("creditReport ", "企业征信报告（近1个月）"),
        fddbrfqsfgrzxSjkzrfqsfgrzx("fddbrfqsfgrzx/sjkzrfqsfgrzx", "法定代表人夫妻双方个人征信（近1个月）/实际控制人夫妻双方个人征信（近1个月）"),
        fddbrfqsfgrzxSjkzrfqsfgrzxQ("fddbrfqsfgrzx&sjkzrfqsfgrzx", "法定代表人夫妻双方个人征信（近1个月）&实际控制人夫妻双方个人征信（近1个月）"),
        qyj6gyyhls("qyj6gyyhls", "企业近6个月银行流水"),
        xczp("xczp", "现场照片"),
        operation("operation", "经营情况"),
        zczm("zczm", "资产证明"),
        jyxkzTzjyxkz("jyxkz/tzjyxkz", "经营许可证/特种经营许可证"),
        xfbazm("xfbazm", "消防备案证明"),
        jmhtjfjJmbzjzfpz("jmhtjfj/jmbzjzfpz", "加盟合同及附件/加盟保证金支付凭证"),
        cght("cght", "采购合同"),
        ppfpgbgPpftzys("ppfpgbg/ppftzys", "品牌方评估报告/品牌方投资预算"),
        ppfcwbb("ppfcwbb", "品牌方财务报表"),
        ppfpgbz("ppfpgbz", "品牌方评估标准"),
        ppfpgbg("ppfpgbg", "品牌方评估报告"),
        syyc("syyc", "收益预测（含逻辑）"),
        sfbzjsjjd("sfbzjsjjd", "收费标准及时间节点"),
        zjlkzjdjqk("zjlkzjdjqk", "资金流控制节点及情况"),
        ptsjzl("ptsjzl", "平台数据资料");
//        corporationIdCard("corporationIdCard", "法定代表人身份证正反面"),
//        actualControllerIdCard("actualControllerIdCard", "实际控制人身份证正反面"),
//        fixedAssets("fixedAssets","固定资产");
//        other("other", "其他");

        private String value;
        private String msg;

        NecessaryData(String value, String msg) {
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
            for (NecessaryData a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (NecessaryData item : NecessaryData.values()) {
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
     * 产品状态
     */
    public enum ProductStatus {
        YES(1, "生效"),
        NO(2, "未生效");
        private Integer value;
        private String msg;

        ProductStatus(Integer value, String msg) {
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
            for (ProductStatus a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (ProductStatus item : ProductStatus.values()) {
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
     * 产品的平台状态（1待提交 2 待审核 3 已生效 4 待生效  5 拒绝）
     */
    public enum PlatformStatus {
        WAIT_SUBMIT(1, "待提交"),
        WAIT_AUDIT(2, "待审核"),
        EFFECT(3, "已生效"),
        WAIT_EFFECT(4, "待生效"),
        REFUSE(5, "拒绝");
        private Integer value;
        private String msg;

        PlatformStatus(Integer value, String msg) {
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
            for (PlatformStatus a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (PlatformStatus item : PlatformStatus.values()) {
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
     * 审核状态（1 通过 2 拒绝 3退回）
     */
    public enum AuditStatus {
        YES(1, "通过"),
        NO(2, "拒绝"),
        RETURN(3, "退回");
        private Integer value;
        private String msg;

        private AuditStatus(Integer value, String msg) {
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
            for (AuditStatus a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

        private static final JSONArray VALUE_ARR = new JSONArray();

        static {
            JSONObject tmp;
            for (AuditStatus item : AuditStatus.values()) {
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
     * 审核产品类型 1融资产品 2投资理财产品
     */
    public enum AuditType {
        FINANCE(1, "融资产品"),
        INVEST(2, "投资理财产品");
        private Integer value;
        private String msg;

        private AuditType(Integer value, String msg) {
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
            for (AuditType a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }

    }

    /**
     * 产品类型
     */
    public enum ProductType {
        FUND(1, "基金"),
        FINANCE(2, "理财");
        @Getter
        private Integer value;
        @Getter
        private String label;

        ProductType(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<Integer, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (ProductType item : ProductType.values()) {
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
     * 准入限制
     */
    public enum AccessLimit {
        BusinessTime("1", "营业时间一年以上"),
        ATAX("2", "A级纳税人");
        @Getter
        private String value;
        @Getter
        private String label;

        AccessLimit(String value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<String, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (AccessLimit item : AccessLimit.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(String value) {
            return map.get(value);
        }
    }

    /**
     * 融资额度范围
     */
    public enum QuotaRange {
        W_LESS_50("0-50", "50万及其以下"),
        W_50_100("50-100", "50-100万"),
        W_100_300("100-300", "100-300万"),
        W_300_500("300-500", "300-500万"),
        W_500_1000("500-1000", "500-1000万"),
        W_1000_PLUS("1000+", "1000万以上");
        @Getter
        private String value;
        @Getter
        private String label;


        QuotaRange(String value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<String, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (QuotaRange item : QuotaRange.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(String value) {
            return map.get(value);
        }
    }

    /**
     * 融资期限范围
     */
    public enum TermRange {
        W_LESS_50("0-6", "6个月及其以下"),
        W_50_100("6-12", "6-12个月"),
        W_100_300("12-24", "12-24个月"),
        W_300_500("24-36", "24-36个月"),
        W_1000_PLUS("36+", "36及以上");
        @Getter
        private String value;
        @Getter
        private String label;


        TermRange(String value, String label) {
            this.value = value;
            this.label = label;
        }

        @Getter
        private static List<JSONObject> valueArr = new ArrayList<>();
        private static Map<String, String> map = new HashMap<>();

        static {
            JSONObject tmp;
            for (TermRange item : TermRange.values()) {
                tmp = new JSONObject();
                tmp.put("value", item.getValue());
                tmp.put("label", item.getLabel());
                valueArr.add(tmp);
                map.put(item.getValue(), item.getLabel());
            }
        }

        public static String getLabel(String value) {
            return map.get(value);
        }
    }
}
