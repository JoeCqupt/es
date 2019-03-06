package com.example.web;

import com.example.Constants.ResponseCode;
import com.example.DO.User;
import com.example.DTO.ResultDTO;
import com.example.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultDTO register(User user) {
        logger.debug("user register -->");
        // 校验参数
        // todo 这里参数校验的方式不是很优雅，可以使用 hibernate Validator 注解实现
        // 这里没有校验 string 的长度 // todo
        if (StringUtils.isBlank(user.getUserName()) ||
                StringUtils.isBlank(user.getUserNickName()) ||
                StringUtils.isBlank(user.getUserPass()) ||
                user.getUserAge() < 0 || user.getUserAge() > 200) {
            return ResultDTO.fail(ResponseCode.PARAM_ERROR);
        }
        logger.debug("user register -->" + user.getUserName());
        // 这里的实现也不是很优雅，可以使用全局异常处理器
        boolean result = userService.register(user);
        if (!result) {
            // 实现不够优雅，错误码的作用没有发挥出来，应该在全局异常处理器中根据不同的异常错误码进行返回 // todo
            ResultDTO.fail(ResponseCode.UNKNOWN_ERROR);
        }
        return ResultDTO.success(user);
    }

}
