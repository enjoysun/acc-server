package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysUserRole;
import com.yunjia.lark.model.reqvo.SysUserRoleReqVo;
import com.yunjia.lark.model.respvo.SysUserRoleRespVo;
import com.yunjia.lark.mapper.SysUserRoleMapper;
import com.yunjia.lark.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 用户角色表(SysUserRole)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:44:48
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserRoleRespVo queryById(Long id) {
        SysUserRole sysUserRole = this.sysUserRoleMapper.queryById(id);
        
        //将SysUserRole转成SysUserRoleRespVo
        SysUserRoleRespVo sysUserRoleRespVo = null;
        if (sysUserRole != null){
            sysUserRoleRespVo = new SysUserRoleRespVo();
            BeanUtils.copyProperties(sysUserRole, sysUserRoleRespVo);
        }
        
        return sysUserRoleRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUserRoleRespVo> queryPageList(SysUserRoleReqVo sysUserRoleReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysUserRole转成SysUserRoleRespVo
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleReqVo, sysUserRole);
        List<SysUserRole> sysUserRoleList = this.sysUserRoleMapper.queryAll(sysUserRole);
        
        PageInfo<SysUserRoleRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysUserRoleList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRoleRespVo save(SysUserRoleReqVo sysUserRoleReqVo) {
        //将SysUserRoleReqVo转成SysUserRole
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleReqVo, sysUserRole);
        this.sysUserRoleMapper.insert(sysUserRole);
        
        return this.queryById(sysUserRole.getId());
    }

    /**
     * 修改数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRoleRespVo edit(SysUserRoleReqVo sysUserRoleReqVo) {
        //将SysUserRoleRespVo转成SysUserRole
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtils.copyProperties(sysUserRoleReqVo, sysUserRole);
        this.sysUserRoleMapper.update(sysUserRole);
        
        return this.queryById(sysUserRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserRoleMapper.deleteById(id) > 0;
    }
}