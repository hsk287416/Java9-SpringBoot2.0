package com.spring.hsk.xunwu.common;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
public class AppErrorCtrl implements ErrorController {

    private static final String ERROR_PATH = "/error";
    private static final int[] ERROR_CODE_ARR = {403, 404, 500, 505};

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPage(HttpServletResponse response, HttpServletRequest request) {
        int status = response.getStatus();

        if (ArrayUtils.contains(ERROR_CODE_ARR, status)) {
            return "errors/" + Integer.toString(status);
        }
        return "index";
    }
}
