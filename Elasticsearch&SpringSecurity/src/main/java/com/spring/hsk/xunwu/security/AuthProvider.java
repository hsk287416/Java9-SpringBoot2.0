package com.spring.hsk.xunwu.security;

import com.spring.hsk.xunwu.pojo.User;
import com.spring.hsk.xunwu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private IUserService iUserService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = iUserService.findUserByName(userName);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("用户名密码错误");
        }

        if (this.passwordEncoder.matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }
        throw new BadCredentialsException("用户名密码错误");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
