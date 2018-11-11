package com.spring.hsk.xunwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeCtrl {
    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/bye")
    public ModelAndView logout(ModelAndView modelAndView) {
        modelAndView.setViewName("logout");
        return modelAndView;
    }
}
