package com.example.web;

import com.example.DO.User;
import com.example.DTO.ResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("test")
    @ResponseBodyÅ
    public ResultDTO test(@RequestBody User user) {
        return ResultDTO.success(new User());
    }
}
