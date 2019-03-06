package com.example.DTO;

import com.example.Constants.ResponseCode;

/**
 * json 响应对象
 */
public class ResultDTO<T> {
    private boolean isSuccess;
    private int code;
    private String msg;
    private T data;
    private int total;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static <T> ResultDTO success(T data) {
        ResultDTO<T> resultDTO = new ResultDTO();
        resultDTO.setSuccess(true);
        resultDTO.setCode(ResponseCode.OK.getCode());
        resultDTO.setMsg(ResponseCode.OK.getMsg());
        resultDTO.setData(data);
        return resultDTO;
    }

    public static <T> ResultDTO fail(ResponseCode responseCode) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setSuccess(false);
        resultDTO.setCode(responseCode.getCode());
        resultDTO.setMsg(responseCode.getMsg());
        resultDTO.setData(null);
        return resultDTO;
    }
}
