package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysGroup;
import com.yunjia.lark.model.reqvo.SysGroupReqVo;
import com.yunjia.lark.model.respvo.SysGroupRespVo;
import com.yunjia.lark.mapper.SysGroupMapper;
import com.yunjia.lark.service.SysGroupService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 用户组(SysGroup)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:46:31
 */
@Service("sysGroupService")
public class SysGroupServiceImpl implements SysGroupService {

    @Resource
    private SysGroupMapper sysGroupMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysGroupRespVo queryById(Long id) {
        SysGroup sysGroup = this.sysGroupMapper.queryById(id);
        
        //将SysGroup转成SysGroupRespVo
        SysGroupRespVo sysGroupRespVo = null;
        if (sysGroup != null){
            sysGroupRespVo = new SysGroupRespVo();
            BeanUtils.copyProperties(sysGroup, sysGroupRespVo);
        }
        
        return sysGroupRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysGroupReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysGroupRespVo> queryPageList(SysGroupReqVo sysGroupReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysGroup转成SysGroupRespVo
        SysGroup sysGroup = new SysGroup();
        BeanUtils.copyProperties(sysGroupReqVo, sysGroup);
        List<SysGroup> sysGroupList = this.sysGroupMapper.queryAll(sysGroup);
        
        PageInfo<SysGroupRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysGroupList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysGroupReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysGroupRespVo save(SysGroupReqVo sysGroupReqVo) {
        //将SysGroupReqVo转成SysGroup
        SysGroup sysGroup = new SysGroup();
        BeanUtils.copyProperties(sysGroupReqVo, sysGroup);
        this.sysGroupMapper.insert(sysGroup);
        
        return this.queryById(sysGroup.getId());
    }

    /**
     * 修改数据
     *
     * @param sysGroupReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysGroupRespVo edit(SysGroupReqVo sysGroupReqVo) {
        //将SysGroupRespVo转成SysGroup
        SysGroup sysGroup = new SysGroup();
        BeanUtils.copyProperties(sysGroupReqVo, sysGroup);
        this.sysGroupMapper.update(sysGroup);
        
        return this.queryById(sysGroup.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysGroupMapper.deleteById(id) > 0;
    }
}