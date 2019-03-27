package com.example.REQ.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 用户注册请求对象
 */
public class UserRegisterREQ {
    @NotNull
    @NotBlank
    @Max(20)
    @Min(6)
    private String name;
    @Max(200)
    @Min(1)
    private byte age;
    @NotNull
    @NotBlank
    @Max(20)
    @Min(6)
    private String nickName;
    @NotNull
    @NotBlank
    @Max(20)
    @Min(6)
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
