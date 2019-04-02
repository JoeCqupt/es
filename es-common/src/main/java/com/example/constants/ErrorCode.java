package com.example.constants;

/**
 * 错误码
 * 每一个错误码都是唯一的，在定义新的错误码之前，请全局搜索一下新定义的错误码有没有被使用
 *
 * 错误信息不用在此定义，直接存在前端资源中
 */
public class ErrorCode {

    // 系统相关的错误: 2开头
    public final static int PARAM_ERROR = 20001;  // 参数错误
    public final static int PARAM_NULL = 20002;   // 参数为空
    public final static int UNKNOWN_ERROR = 20003;// 未知错误

    // 用户相关的错误：3开头
    public final static int USER_NAME_OR_PASS_ERROR = 30001; // 用户名或密码错误
    public final static int USER_NOT_EXISTS  = 30002; // 用户不存在


}
