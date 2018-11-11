package com.spring.hsk.xunwu.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserCtrl {

    private static final String VIEW_PREFIX = "user/";

    @GetMapping("/login")
    public ModelAndView userLogin(ModelAndView modelAndView) {

        modelAndView.setViewName(VIEW_PREFIX + "login");
        return modelAndView;
    }

    @GetMapping("/center")
    public ModelAndView userCenter(ModelAndView modelAndView) {

        modelAndView.setViewName(VIEW_PREFIX + "center");
        return modelAndView;
    }
}
