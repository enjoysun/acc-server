package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysGroupRole;
import com.yunjia.lark.model.reqvo.SysGroupRoleReqVo;
import com.yunjia.lark.model.respvo.SysGroupRoleRespVo;
import com.yunjia.lark.mapper.SysGroupRoleMapper;
import com.yunjia.lark.service.SysGroupRoleService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 用户组角色表(SysGroupRole)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:46:23
 */
@Service("sysGroupRoleService")
public class SysGroupRoleServiceImpl implements SysGroupRoleService {

    @Resource
    private SysGroupRoleMapper sysGroupRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysGroupRoleRespVo queryById(Long id) {
        SysGroupRole sysGroupRole = this.sysGroupRoleMapper.queryById(id);
        
        //将SysGroupRole转成SysGroupRoleRespVo
        SysGroupRoleRespVo sysGroupRoleRespVo = null;
        if (sysGroupRole != null){
            sysGroupRoleRespVo = new SysGroupRoleRespVo();
            BeanUtils.copyProperties(sysGroupRole, sysGroupRoleRespVo);
        }
        
        return sysGroupRoleRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysGroupRoleRespVo> queryPageList(SysGroupRoleReqVo sysGroupRoleReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysGroupRole转成SysGroupRoleRespVo
        SysGroupRole sysGroupRole = new SysGroupRole();
        BeanUtils.copyProperties(sysGroupRoleReqVo, sysGroupRole);
        List<SysGroupRole> sysGroupRoleList = this.sysGroupRoleMapper.queryAll(sysGroupRole);
        
        PageInfo<SysGroupRoleRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysGroupRoleList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysGroupRoleRespVo save(SysGroupRoleReqVo sysGroupRoleReqVo) {
        //将SysGroupRoleReqVo转成SysGroupRole
        SysGroupRole sysGroupRole = new SysGroupRole();
        BeanUtils.copyProperties(sysGroupRoleReqVo, sysGroupRole);
        this.sysGroupRoleMapper.insert(sysGroupRole);
        
        return this.queryById(sysGroupRole.getId());
    }

    /**
     * 修改数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysGroupRoleRespVo edit(SysGroupRoleReqVo sysGroupRoleReqVo) {
        //将SysGroupRoleRespVo转成SysGroupRole
        SysGroupRole sysGroupRole = new SysGroupRole();
        BeanUtils.copyProperties(sysGroupRoleReqVo, sysGroupRole);
        this.sysGroupRoleMapper.update(sysGroupRole);
        
        return this.queryById(sysGroupRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysGroupRoleMapper.deleteById(id) > 0;
    }
}