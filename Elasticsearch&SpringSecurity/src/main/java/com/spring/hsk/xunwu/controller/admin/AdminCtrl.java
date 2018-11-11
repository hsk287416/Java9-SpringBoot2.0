package com.spring.hsk.xunwu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminCtrl {

    private static final String VIEW_PREFIX = "admin/";

    @GetMapping("/center")
    public ModelAndView adminCenter(ModelAndView modelAndView){

        modelAndView.setViewName(VIEW_PREFIX + "center");
        return modelAndView;
    }

    @GetMapping("/welcome")
    public ModelAndView adminWelcome(ModelAndView modelAndView){

        modelAndView.setViewName(VIEW_PREFIX + "welcome");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView adminLogin(ModelAndView modelAndView){

        modelAndView.setViewName(VIEW_PREFIX + "login");
        return modelAndView;
    }
}
