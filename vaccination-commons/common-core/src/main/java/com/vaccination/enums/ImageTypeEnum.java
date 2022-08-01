package com.vaccination.enums;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author wei.wang
 * @Package com.hcmis.loan.core.enums
 * @Description: ${TODO}
 * @date 2021/4/19 18:28
 */
public enum ImageTypeEnum {
    license("license", "营业执照"),
    taxInformation("taxInformation", "纳税信息"),
    bylaw("bylaw", "公司章程及修正案"),
    verificationReport("verificationReport", "企业验资报告"),
    shareholdersMeeting("shareholdersMeeting", "股东会决议或董事会决议"),
    fddbrfqsfsfzSjkzrfqsfsfz("fddbrfqsfsfz/sjkzrfqsfsfz", "法定代表人夫妻双方身份证正反面/实际控制人夫妻双方身份证正反面"),
    fddbrfqsfsfz("fddbrfqsfsfz", "法定代表人夫妻双方身份证正反面"),
    sjkzrfqsfsfz("sjkzrfqsfsfz", "实际控制人夫妻双方身份证正反面"),
    fddbrfqsfsfzSjkzrfqsfsfzq("fddbrfqsfsfz&sjkzrfqsfsfz", "法定代表人夫妻双方身份证正反面&实际控制人夫妻双方身份证正反面"),
    fddbrfqsfjhzSjkzrfqsfjhz("fddbrfqsfjhz/sjkzrfqsfjhz", "法定代表人夫妻双方结婚证/实际控制人夫妻双方结婚证"),
    fddbrfqsfjhz("fddbrfqsfjhz", "法定代表人夫妻双方结婚证"),
    sjkzrfqsfjhz("sjkzrfqsfjhz", "实际控制人夫妻双方结婚证"),
    fddbrfqsfhkbSjkzrfqsfhkb("fddbrfqsfhkb/sjkzrfqsfhkb", "法定代表人夫妻双方户口本/实际控制人夫妻双方户口本"),
    fddbrfqsfhkb("fddbrfqsfhkb", "法定代表人夫妻双方户口本"),
    sjkzrfqsfhkb("sjkzrfqsfhkb", "实际控制人夫妻双方户口本"),
    agentIdCard("agentIdCard", "授权办理人身份证正反面"),
    bankAccount("bankAccount", "企业银行账户信息"),
    jycdzlhthfcz("jycdzlhthfcz", "经营场地租赁合同或房产证"),
    jycdzjzfpz("jycdzjzfpz", "经营场地租金支付凭证"),
    creditReport("creditReport ", "企业征信报告（近1个月）"),
    fddbrfqsfgrzxSjkzrfqsfgrzx("fddbrfqsfgrzx/sjkzrfqsfgrzx", "法定代表人夫妻双方个人征信（近1个月）/实际控制人夫妻双方个人征信（近1个月）"),
    fddbrfqsfgrzx("fddbrfqsfgrzx", "法定代表人夫妻双方个人征信（近1个月）"),
    sjkzrfqsfgrzx("sjkzrfqsfgrzx", "实际控制人夫妻双方个人征信（近1个月）"),
    fddbrfqsfgrzxSjkzrfqsfgrzxQ("fddbrfqsfgrzx&sjkzrfqsfgrzx", "法定代表人夫妻双方个人征信（近1个月）&实际控制人夫妻双方个人征信（近1个月）"),
    qyj6gyyhls("qyj6gyyhls", "企业近6个月银行流水"),
    xczp("xczp", "现场照片"),
    operation("operation", "经营情况"),
    zczm("zczm", "资产证明"),
    jyxkzTzjyxkz("jyxkz/tzjyxkz", "经营许可证/特种经营许可证"),
    jyxkz("jyxkz", "经营许可证"),
    tzjyxkz("tzjyxkz", "特种经营许可证"),
    xfbazm("xfbazm", "消防备案证明"),
    jmhtjfjJmbzjzfpz("jmhtjfj/jmbzjzfpz", "加盟合同及附件/加盟保证金支付凭证"),
    jmhtjfj("jmhtjfj", "加盟合同及附件"),
    jmbzjzfpz("jmbzjzfpz", "加盟保证金支付凭证"),
    cght("cght", "采购合同"),
    ppfpgbgPpftzys("ppfpgbg/ppftzys", "品牌方评估报告/品牌方投资预算"),
    ppftzys("ppftzys", "品牌方投资预算"),
    ppfcwbb("ppfcwbb", "品牌方财务报表"),
    ppfpgbz("ppfpgbz", "品牌方评估标准"),
    ppfpgbg("ppfpgbg", "品牌方评估报告"),
    syyc("syyc", "收益预测（含逻辑）"),
    sfbzjsjjd("sfbzjsjjd", "收费标准及时间节点"),
    zjlkzjdjqk("zjlkzjdjqk", "资金流控制节点及情况"),
    ptsjzl("ptsjzl", "平台数据资料"),
    corporationIdCard("corporationIdCard", "法定代表人身份证正反面"),
    other("other", "其他"),
    inquireReport("inquireReport", "尽调报告"),
    AD("ad", "广告"),
    face("face", "人脸照片");
    private String value;
    private String msg;

    private ImageTypeEnum(String value, String msg) {
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
        for (ImageTypeEnum a : values()) {
            if (a.getValue().equals(val)) {
                return a.getMsg();
            }
        }
        return null;
    }

    public static ImageTypeEnum getByValue(String value){
        for(ImageTypeEnum imageTypeEnum : values()){
            if (imageTypeEnum.getValue().equals(value)) {
                return imageTypeEnum;
            }
        }
        return null;
    }

    private static final JSONArray VALUE_ARR = new JSONArray();

    static {
        JSONObject tmp;
        for (ImageTypeEnum item : ImageTypeEnum.values()) {
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
