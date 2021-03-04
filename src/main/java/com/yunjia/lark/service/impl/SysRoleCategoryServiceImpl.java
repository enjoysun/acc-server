package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysRoleCategory;
import com.yunjia.lark.model.reqvo.SysRoleCategoryReqVo;
import com.yunjia.lark.model.respvo.SysRoleCategoryRespVo;
import com.yunjia.lark.mapper.SysRoleCategoryMapper;
import com.yunjia.lark.service.SysRoleCategoryService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 角色类别表(SysRoleCategory)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:45:04
 */
@Service("sysRoleCategoryService")
public class SysRoleCategoryServiceImpl implements SysRoleCategoryService {

    @Resource
    private SysRoleCategoryMapper sysRoleCategoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRoleCategoryRespVo queryById(Long id) {
        SysRoleCategory sysRoleCategory = this.sysRoleCategoryMapper.queryById(id);
        
        //将SysRoleCategory转成SysRoleCategoryRespVo
        SysRoleCategoryRespVo sysRoleCategoryRespVo = null;
        if (sysRoleCategory != null){
            sysRoleCategoryRespVo = new SysRoleCategoryRespVo();
            BeanUtils.copyProperties(sysRoleCategory, sysRoleCategoryRespVo);
        }
        
        return sysRoleCategoryRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysRoleCategoryRespVo> queryPageList(SysRoleCategoryReqVo sysRoleCategoryReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysRoleCategory转成SysRoleCategoryRespVo
        SysRoleCategory sysRoleCategory = new SysRoleCategory();
        BeanUtils.copyProperties(sysRoleCategoryReqVo, sysRoleCategory);
        List<SysRoleCategory> sysRoleCategoryList = this.sysRoleCategoryMapper.queryAll(sysRoleCategory);
        
        PageInfo<SysRoleCategoryRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysRoleCategoryList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleCategoryRespVo save(SysRoleCategoryReqVo sysRoleCategoryReqVo) {
        //将SysRoleCategoryReqVo转成SysRoleCategory
        SysRoleCategory sysRoleCategory = new SysRoleCategory();
        BeanUtils.copyProperties(sysRoleCategoryReqVo, sysRoleCategory);
        this.sysRoleCategoryMapper.insert(sysRoleCategory);
        
        return this.queryById(sysRoleCategory.getId());
    }

    /**
     * 修改数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysRoleCategoryRespVo edit(SysRoleCategoryReqVo sysRoleCategoryReqVo) {
        //将SysRoleCategoryRespVo转成SysRoleCategory
        SysRoleCategory sysRoleCategory = new SysRoleCategory();
        BeanUtils.copyProperties(sysRoleCategoryReqVo, sysRoleCategory);
        this.sysRoleCategoryMapper.update(sysRoleCategory);
        
        return this.queryById(sysRoleCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysRoleCategoryMapper.deleteById(id) > 0;
    }
}