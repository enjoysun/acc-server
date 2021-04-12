package com.yunjia.lark.config.security.authorization;

import com.google.gson.Gson;
import com.yunjia.lark.model.entity.ExplorePermission;
import com.yunjia.lark.model.entity.RoleTree;
import com.yunjia.lark.model.entity.SysRole;
import com.yunjia.lark.model.respvo.SysRoleRespVo;
import com.yunjia.lark.service.SysRoleService;
import com.yunjia.lark.service.impl.SysRoleServiceImpl;
import com.yunjia.lark.util.GsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @Author myou
 * @Date 2021/3/16  5:05 下午
 * 自定义用户的permission对象(自定义角色对应权限数据结构)
 * <p>
 * 该类只提供一个公用返回用户的权限树jsonString
 * User
 * |
 * Role
 * |
 * explore
 * |
 * menu interface button
 */
public class UserGrantedAuthority implements GrantedAuthority {

//    private ExplorePermission explorePermission;

    private List<SysRoleRespVo> sysRoleRespVos;

    public UserGrantedAuthority(List<SysRoleRespVo> sysRoleRespVos) {
        this.sysRoleRespVos = sysRoleRespVos;
    }

    @Override
    public String getAuthority() {
        return GsonService.getInstance().toJson(this.getRolePermission());
    }

    public List<ExplorePermission> getRolePermission() {
        // 根据角色列表获取全部权限
        return null;
    }
}
