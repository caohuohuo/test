package com.vaccination.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vaccination.utils.PageUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haoxr
 * @date 2020-06-23
 **/
@Data
public class Result implements Serializable {

    private String code;

    private Object data;

    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer total;

    public static <T> Result success() {
        return result(com.vaccination.result.ResultCode.SUCCESS, null);
    }

    public static <T> Result success(T data) {
        com.vaccination.result.ResultCode rce = com.vaccination.result.ResultCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            rce = com.vaccination.result.ResultCode.SYSTEM_EXECUTION_ERROR;
        }
        return result(rce, data);
    }

    public static Result success(IPage page) {
        return Result.success(new PageUtils<>(page));
    }


    public static <T> Result failed() {
        return result(com.vaccination.result.ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), com.vaccination.result.ResultCode.SYSTEM_EXECUTION_ERROR.getMsg(), null);
    }

    public static <T> Result failed(String msg) {
        return result(com.vaccination.result.ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), msg, null);
    }

    public static <T> Result judge(boolean status) {
        if (status) {
            return success();
        } else {
            return failed();
        }
    }

    public static <T> Result failed(com.vaccination.result.IResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }

    private static <T> Result result(com.vaccination.result.IResultCode resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    private static <T> Result result(String code, String msg, T data) {
        Result result = new Result();
        result.setCode(code);
        if (data instanceof List) {
            Map<String, T> map = new HashMap<>();
            map.put("list", data);
            result.setData(map);
        } else {
            result.setData(data);
        }
        result.setMsg(msg);
        return result;
    }

    public static <T> Result success(T data, Long total) {
        Result result = result(com.vaccination.result.ResultCode.SUCCESS.getCode(), com.vaccination.result.ResultCode.SUCCESS.getMsg(), data);
        result.setTotal(total.intValue());
        return result;
    }

    public static <T> Result success(String msg) {
        return result(com.vaccination.result.ResultCode.SUCCESS.getCode(), msg, null);
    }

}
