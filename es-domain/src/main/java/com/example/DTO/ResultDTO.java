package com.example.DTO;

import com.example.constants.ErrorCode;

/**
 * json 响应对象
 */
public class ResultDTO<T> {
    private boolean isSuccess;
    private int code;
    private T data;

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


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <T> ResultDTO success(T data) {
        ResultDTO<T> resultDTO = new ResultDTO();
        resultDTO.setSuccess(true);
        resultDTO.setData(data);
        return resultDTO;
    }

    public static <T> ResultDTO fail(int errorCode) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setSuccess(false);
        resultDTO.setCode(errorCode);
        return resultDTO;
    }
}
