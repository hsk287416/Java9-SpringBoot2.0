package com.spring.hsk.xunwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestCtrl {
    @GetMapping("/test")
    public ModelAndView test(ModelAndView modelAndView) {

        modelAndView.setViewName("test");
        return modelAndView;
    }

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.addObject("name", "小懒羊");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
