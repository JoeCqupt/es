package com.example.exception;

/**
 * 定义本系统受检查的异常
 */
public class ESCheckedException extends RuntimeException {

    private int errorCode;


    public ESCheckedException(int errorCode) {
        this.errorCode = errorCode;
    }



    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


}
