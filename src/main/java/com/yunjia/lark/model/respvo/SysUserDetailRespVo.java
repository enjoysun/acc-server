package com.yunjia.lark.model.respvo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author myou
 * @Date 2021/3/20  2:26 下午
 */
@ApiModel("SysUserDetailRespVo")
@Data
public class SysUserDetailRespVo implements Serializable {
    private String UserName;
    // 用户权限集合
    private Collection<? extends GrantedAuthority> Authorities;
    private int state;
    private int locked;
    private int deleted;
}
