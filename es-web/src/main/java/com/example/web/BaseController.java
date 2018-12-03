package com.example.web;

import com.example.DO.User;

import javax.servlet.http.HttpSession;

public class BaseController {
    protected User getUser(HttpSession session) {
        Object user = session.getAttribute("currentUser");
        if (user == null || !(user instanceof User)) {
            return null;
        } else {
            return (User) user;
        }
    }
}
