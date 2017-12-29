package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {
    @RequestMapping("/weStatus")
    public void webStatus(HttpServletResponse response) {
        try {
            response.getWriter().print("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
