package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysUserGroup;
import com.yunjia.lark.model.reqvo.SysUserGroupReqVo;
import com.yunjia.lark.model.respvo.SysUserGroupRespVo;
import com.yunjia.lark.mapper.SysUserGroupMapper;
import com.yunjia.lark.service.SysUserGroupService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 用户——用户组中间表(SysUserGroup)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:44:57
 */
@Service("sysUserGroupService")
public class SysUserGroupServiceImpl implements SysUserGroupService {

    @Resource
    private SysUserGroupMapper sysUserGroupMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserGroupRespVo queryById(Long id) {
        SysUserGroup sysUserGroup = this.sysUserGroupMapper.queryById(id);
        
        //将SysUserGroup转成SysUserGroupRespVo
        SysUserGroupRespVo sysUserGroupRespVo = null;
        if (sysUserGroup != null){
            sysUserGroupRespVo = new SysUserGroupRespVo();
            BeanUtils.copyProperties(sysUserGroup, sysUserGroupRespVo);
        }
        
        return sysUserGroupRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUserGroupRespVo> queryPageList(SysUserGroupReqVo sysUserGroupReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysUserGroup转成SysUserGroupRespVo
        SysUserGroup sysUserGroup = new SysUserGroup();
        BeanUtils.copyProperties(sysUserGroupReqVo, sysUserGroup);
        List<SysUserGroup> sysUserGroupList = this.sysUserGroupMapper.queryAll(sysUserGroup);
        
        PageInfo<SysUserGroupRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysUserGroupList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserGroupRespVo save(SysUserGroupReqVo sysUserGroupReqVo) {
        //将SysUserGroupReqVo转成SysUserGroup
        SysUserGroup sysUserGroup = new SysUserGroup();
        BeanUtils.copyProperties(sysUserGroupReqVo, sysUserGroup);
        this.sysUserGroupMapper.insert(sysUserGroup);
        
        return this.queryById(sysUserGroup.getId());
    }

    /**
     * 修改数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserGroupRespVo edit(SysUserGroupReqVo sysUserGroupReqVo) {
        //将SysUserGroupRespVo转成SysUserGroup
        SysUserGroup sysUserGroup = new SysUserGroup();
        BeanUtils.copyProperties(sysUserGroupReqVo, sysUserGroup);
        this.sysUserGroupMapper.update(sysUserGroup);
        
        return this.queryById(sysUserGroup.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserGroupMapper.deleteById(id) > 0;
    }
}