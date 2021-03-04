package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysOrganization;
import com.yunjia.lark.model.reqvo.SysOrganizationReqVo;
import com.yunjia.lark.model.respvo.SysOrganizationRespVo;
import com.yunjia.lark.mapper.SysOrganizationMapper;
import com.yunjia.lark.service.SysOrganizationService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 组织表(SysOrganization)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:45:56
 */
@Service("sysOrganizationService")
public class SysOrganizationServiceImpl implements SysOrganizationService {

    @Resource
    private SysOrganizationMapper sysOrganizationMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysOrganizationRespVo queryById(Long id) {
        SysOrganization sysOrganization = this.sysOrganizationMapper.queryById(id);
        
        //将SysOrganization转成SysOrganizationRespVo
        SysOrganizationRespVo sysOrganizationRespVo = null;
        if (sysOrganization != null){
            sysOrganizationRespVo = new SysOrganizationRespVo();
            BeanUtils.copyProperties(sysOrganization, sysOrganizationRespVo);
        }
        
        return sysOrganizationRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysOrganizationRespVo> queryPageList(SysOrganizationReqVo sysOrganizationReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysOrganization转成SysOrganizationRespVo
        SysOrganization sysOrganization = new SysOrganization();
        BeanUtils.copyProperties(sysOrganizationReqVo, sysOrganization);
        List<SysOrganization> sysOrganizationList = this.sysOrganizationMapper.queryAll(sysOrganization);
        
        PageInfo<SysOrganizationRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysOrganizationList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysOrganizationRespVo save(SysOrganizationReqVo sysOrganizationReqVo) {
        //将SysOrganizationReqVo转成SysOrganization
        SysOrganization sysOrganization = new SysOrganization();
        BeanUtils.copyProperties(sysOrganizationReqVo, sysOrganization);
        this.sysOrganizationMapper.insert(sysOrganization);
        
        return this.queryById(sysOrganization.getId());
    }

    /**
     * 修改数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysOrganizationRespVo edit(SysOrganizationReqVo sysOrganizationReqVo) {
        //将SysOrganizationRespVo转成SysOrganization
        SysOrganization sysOrganization = new SysOrganization();
        BeanUtils.copyProperties(sysOrganizationReqVo, sysOrganization);
        this.sysOrganizationMapper.update(sysOrganization);
        
        return this.queryById(sysOrganization.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysOrganizationMapper.deleteById(id) > 0;
    }
}