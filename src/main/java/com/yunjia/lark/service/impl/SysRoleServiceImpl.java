package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysRole;
import com.yunjia.lark.model.reqvo.SysRoleReqVo;
import com.yunjia.lark.model.respvo.SysRoleRespVo;
import com.yunjia.lark.mapper.SysRoleMapper;
import com.yunjia.lark.service.SysRoleService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;

import java.util.*;

import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * 角色表(SysRole)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:45:47
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRoleRespVo queryById(Long id) {
        SysRole sysRole = this.sysRoleMapper.queryById(id);

        //将SysRole转成SysRoleRespVo
        SysRoleRespVo sysRoleRespVo = null;
        if (sysRole != null) {
            sysRoleRespVo = new SysRoleRespVo();
            BeanUtils.copyProperties(sysRole, sysRoleRespVo);
        }

        return sysRoleRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysRoleReqVo 实例对象
     * @param pageNum      页数
     * @param pageSize     每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysRoleRespVo> queryPageList(SysRoleReqVo sysRoleReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        //将SysRole转成SysRoleRespVo
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleReqVo, sysRole);
        List<SysRole> sysRoleList = this.sysRoleMapper.queryAll(sysRole);

        PageInfo<SysRoleRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysRoleList), pageInfo);
        return pageInfo;
    }

    @Override
    public List<SysRoleRespVo> queryAllRolesByUserId(Long id) {
        List<SysRole> sysRoles = this.sysRoleMapper.queryAllRolesByUserId(id);
        ArrayList<SysRoleRespVo> sysRoleRespVos = new ArrayList<>();
        //将SysRole转成SysRoleRespVo
        sysRoles.forEach(item -> {
            SysRoleRespVo sysRoleRespVo = new SysRoleRespVo();
            BeanUtils.copyProperties(item, sysRoleRespVo);
            sysRoleRespVos.add(sysRoleRespVo);
        });
        return sysRoleRespVos;
    }

    /**
     * 新增数据
     *
     * @param sysRoleReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleRespVo save(SysRoleReqVo sysRoleReqVo) {
        //将SysRoleReqVo转成SysRole
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleReqVo, sysRole);
        this.sysRoleMapper.insert(sysRole);

        return this.queryById(sysRole.getId());
    }

    /**
     * 修改数据
     *
     * @param sysRoleReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleRespVo edit(SysRoleReqVo sysRoleReqVo) {
        //将SysRoleRespVo转成SysRole
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleReqVo, sysRole);
        this.sysRoleMapper.update(sysRole);

        return this.queryById(sysRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysRoleMapper.deleteById(id) > 0;
    }
}