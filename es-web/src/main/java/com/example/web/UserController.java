package com.example.web;

import com.example.DO.User;
import com.example.DTO.ResultDTO;
import com.example.REQ.user.UserRegisterREQ;
import com.example.constants.ErrorCode;
import com.example.exception.ESCheckedException;
import com.example.service.UserService;
import com.example.util.MyAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultDTO register(@RequestBody UserRegisterREQ req) {

        userService.register(req);
        return ResultDTO.success(null);
    }

}
