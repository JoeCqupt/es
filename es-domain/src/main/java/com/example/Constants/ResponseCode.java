package com.example.Constants;

public enum ResponseCode {
    OK(20000,"ok");
    int code;
    String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
