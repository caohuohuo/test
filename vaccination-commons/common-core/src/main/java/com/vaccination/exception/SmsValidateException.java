package com.vaccination.exception;


import com.vaccination.result.ResultCode;

/**
 * BadRequestException
 * 4/16/21
 *
 * @Author xiaoguang
 */
public class SmsValidateException extends RuntimeException {

    private String status;
    private String msg;

    public SmsValidateException(String msg) {
        super(msg);
    }


    public SmsValidateException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.status = resultCode.getCode();
    }
}
