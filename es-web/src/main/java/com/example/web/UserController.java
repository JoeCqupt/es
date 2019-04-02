package com.example.web;

import com.example.DO.User;
import com.example.DTO.ResultDTO;
import com.example.REQ.user.UserRegisterREQ;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultDTO register(@RequestBody @Validated UserRegisterREQ req) {
        logger.debug("user register --> {}", req);

        User user = new User();
        user.setUserName(req.getName());
        user.setUserAge(req.getAge());
        user.setUserNickName(req.getNickName());
        user.setUserPass(req.getPass());

        userService.register(user);
        return ResultDTO.success(user);
    }

}
