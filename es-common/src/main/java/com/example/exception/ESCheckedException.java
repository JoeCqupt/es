package com.example.exception;

/**
 *
 * 定义异常
 */
public class ESCheckedException extends RuntimeException {

    private int errorCode;


    public ESCheckedException(int errorCode){
        this.errorCode = errorCode;
    }

}
