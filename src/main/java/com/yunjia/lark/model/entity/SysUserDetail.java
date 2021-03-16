package com.yunjia.lark.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author myou
 * @Date 2021/3/9  11:32 上午
 */
public class SysUserDetail implements UserDetails {
    private String UserName;
    private String UserPassword;
    // 用户权限集合
    private Collection<? extends GrantedAuthority> Authorities;
    private int state;
    private int locked;
    private int deleted;

    public SysUserDetail(String userName, String userPassword, Collection<? extends GrantedAuthority> authorities, int state, int locked, int deleted) {
        UserName = userName;
        UserPassword = userPassword;
        Authorities = authorities;
        this.state = state;
        this.locked = locked;
        this.deleted = deleted;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.Authorities;
    }

    @Override
    public String getPassword() {
        return this.UserPassword;
    }

    @Override
    public String getUsername() {
        return this.UserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.state == 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.locked == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.deleted == 0;
    }
}
