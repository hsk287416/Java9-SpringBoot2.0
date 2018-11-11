package com.spring.hsk.xunwu.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private final Map<String, String> authEntryPointMap;
    private PathMatcher pathMatcher;

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        this.pathMatcher = new AntPathMatcher();
        this.authEntryPointMap = new HashMap<>();
        this.authEntryPointMap.put("/user/**", "/user/login");
        this.authEntryPointMap.put("/admin/**", "/admin/login");
    }

    /**
     * 根据请求跳转到指定的页面，父类是默认使用loginFormUrl
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");

        for (Map.Entry<String, String> entry: this.authEntryPointMap.entrySet()) {
            if (this.pathMatcher.match(entry.getKey(), uri)) {
                return entry.getValue();
            }
        }

        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}
