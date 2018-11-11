package com.spring.hsk.xunwu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class User implements UserDetails {
    private Integer id;

    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    private Integer status;

    private Date createTime;

    private Date lastLoginTime;

    private Date lastUpdateTime;

    private String avatar;

    private List<GrantedAuthority> authorityList;

    public User(Integer id, String name, String email, String phoneNumber, String password, Integer status, Date createTime, Date lastLoginTime, Date lastUpdateTime, String avatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.status = status;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.lastUpdateTime = lastUpdateTime;
        this.avatar = avatar;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}