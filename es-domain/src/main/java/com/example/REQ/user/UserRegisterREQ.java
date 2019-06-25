package com.example.REQ.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 用户注册请求对象
 */

@Data
public class UserRegisterREQ {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, max = 20, message = "用户名长度为6-20")
    private String name;

    @Max(value = 200, message = "年龄最大为20")
    @Min(value = 1, message = "年龄最小为1")
    private byte age;

    @NotBlank(message = "昵称不能为空")
    @Length(min = 6, max = 20, message = "用户昵称长度为6-20")
    private String nickName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度为6-20")
    private String pass;

}
