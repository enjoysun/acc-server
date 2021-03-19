package com.yunjia.lark.service.impl;

import com.yunjia.lark.config.security.authorization.UserGrantedAuthority;
import com.yunjia.lark.model.entity.SysUserDetail;
import com.yunjia.lark.model.respvo.SysRoleRespVo;
import com.yunjia.lark.model.respvo.SysUserRespVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author myou
 * @Date 2021/3/16  4:55 下午
 */
@Service
public class SysUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private SysRoleServiceImpl sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(s))
            throw new UsernameNotFoundException("用户名为空");
        SysUserRespVo userRespVo = sysUserService.queryByUserNameOrAccount(s);
        if (null == userRespVo)
            throw new UsernameNotFoundException("不存在用户");
        // 验证密码是否通过

        // 查询用户所有角色
        List<SysRoleRespVo> sysRoleRespVos = sysRoleService.queryAllRolesByUserId(userRespVo.getId());

        // 构造角色列表而非权限路由路径
        UserGrantedAuthority userGrantedAuthority = new UserGrantedAuthority(sysRoleRespVos);
        SysUserDetail sysUserDetail = new SysUserDetail(
                s,
                userRespVo.getPassword(),
                userRespVo.getSalt(),
                Collections.singletonList(userGrantedAuthority),
                userRespVo.getStatus(),
                userRespVo.getLocked(),
                userRespVo.getDeleted()
        );
        return sysUserDetail;
    }
}
