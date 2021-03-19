package com.yunjia.lark.service.impl;

import com.yunjia.lark.mapper.SysRoleMapper;
import com.yunjia.lark.model.entity.SysUser;
import com.yunjia.lark.model.reqvo.SysUserReqVo;
import com.yunjia.lark.model.respvo.SysUserRespVo;
import com.yunjia.lark.mapper.SysUserMapper;
import com.yunjia.lark.service.SysUserService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;

import java.util.*;

import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:40:02
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserRespVo queryById(Long id) {
        SysUser sysUser = this.sysUserMapper.queryById(id);

        //将SysUser转成SysUserRespVo
        SysUserRespVo sysUserRespVo = null;
        if (sysUser != null) {
            sysUserRespVo = new SysUserRespVo();
            BeanUtils.copyProperties(sysUser, sysUserRespVo);
        }

        return sysUserRespVo;
    }

    @Override
    public SysUserRespVo queryByUserNameOrAccount(String name) {
        SysUser sysUser = this.sysUserMapper.queryByUserNameOrAccount(name);

        //将SysUser转成SysUserRespVo
        SysUserRespVo sysUserRespVo = null;
        if (sysUser != null) {
            sysUserRespVo = new SysUserRespVo();
            BeanUtils.copyProperties(sysUser, sysUserRespVo);
        }

        return sysUserRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysUserReqVo 实例对象
     * @param pageNum      页数
     * @param pageSize     每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUserRespVo> queryPageList(SysUserReqVo sysUserReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        //将SysUser转成SysUserRespVo
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserReqVo, sysUser);
        List<SysUser> sysUserList = this.sysUserMapper.queryAll(sysUser);

        PageInfo<SysUserRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysUserList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysUserReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRespVo save(SysUserReqVo sysUserReqVo) {
        //将SysUserReqVo转成SysUser
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserReqVo, sysUser);
        this.sysUserMapper.insert(sysUser);

        return this.queryById(sysUser.getId());
    }

    /**
     * 修改数据
     *
     * @param sysUserReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRespVo edit(SysUserReqVo sysUserReqVo) {
        //将SysUserRespVo转成SysUser
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserReqVo, sysUser);
        this.sysUserMapper.update(sysUser);

        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserMapper.deleteById(id) > 0;
    }
}