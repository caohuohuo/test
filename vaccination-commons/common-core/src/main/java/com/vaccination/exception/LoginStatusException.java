package com.vaccination.exception;


import com.vaccination.result.ResultCode;

/**
 * BadRequestException
 * 4/16/21
 *
 * @Author xiaoguang
 */
public class LoginStatusException extends RuntimeException {

    private String status;
    private String msg;

    public LoginStatusException(String msg) {
        super(msg);
    }


    public LoginStatusException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.status = resultCode.getCode();
    }
}
