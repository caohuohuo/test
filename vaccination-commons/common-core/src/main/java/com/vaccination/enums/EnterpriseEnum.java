package com.vaccination.enums;

/**
 * @author wei.wang
 * @Package com.hcmis.loan.admin.common.enums
 * @Description: ${TODO}
 * @date 2021/4/15 09:44
 */
public class EnterpriseEnum {
    /**
     * 是否认证
     */
    public enum IsAuthentication {
        YES(1, "是"), NO(2, "否");
        private Integer value;
        private String msg;

        private IsAuthentication(Integer value, String msg) {
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
            for (IsAuthentication a : values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }

    /**
     * 是否用款
     */
    public enum IsPayment {
        YES(1, "是"), NO(2, "否");
        private Integer value;
        private String msg;

        private IsPayment(Integer value, String msg) {
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
            for (IsPayment a : IsPayment.values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }

    /**
     * 类型（1法人 2经办人）
     */
    public enum StakeholderType {
        FR(1, "法人"), JBR(2, "经办人");
        private Integer value;
        private String msg;

        private StakeholderType(Integer value, String msg) {
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
            for (StakeholderType a : StakeholderType.values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }

    /**
     * 法人是否是经办人
     */
    public enum IsSame {
        YES(1, "是"), NO(2, "否");
        private Integer value;
        private String msg;

        private IsSame(Integer value, String msg) {
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
            for (IsSame a : IsSame.values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }

    /**
     * 接口调用状态
     */
    public enum CallStatus {
        NOT(1, "未调用"), EXCEPTION(2, "异常"),SUCCESS(3, "认证成功"), FAIL(4, "认证失败");
        private Integer value;
        private String msg;

        private CallStatus(Integer value, String msg) {
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
            for (CallStatus a : CallStatus.values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }

    public enum FaceResult {
        IDCARD("IDCARD", "身份证号格式错误"),FAIL("FAIL", "调用失败"),CODE00("00", "认证成功"), CODE01("01", "人脸照验证失败"),CODE02("02", "人脸照验证失败")
        ,CODE03("03", "姓名与身份证号不匹配"),CODE04("04", "人脸照验证失败"),CODE05("05", "人脸照验证失败")
        ,CODE06("06", "身份信息未查得");
        private String value;
        private String msg;

        private FaceResult(String value, String msg) {
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
            for (FaceResult a : FaceResult.values()) {
                if (a.getValue().equals(val)) {
                    return a.getMsg();
                }
            }
            return null;
        }
    }


}
