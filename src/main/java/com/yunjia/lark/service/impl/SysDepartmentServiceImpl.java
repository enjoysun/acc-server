package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysDepartment;
import com.yunjia.lark.model.reqvo.SysDepartmentReqVo;
import com.yunjia.lark.model.respvo.SysDepartmentRespVo;
import com.yunjia.lark.mapper.SysDepartmentMapper;
import com.yunjia.lark.service.SysDepartmentService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 部门表(SysDepartment)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:46:47
 */
@Service("sysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysDepartmentRespVo queryById(Long id) {
        SysDepartment sysDepartment = this.sysDepartmentMapper.queryById(id);
        
        //将SysDepartment转成SysDepartmentRespVo
        SysDepartmentRespVo sysDepartmentRespVo = null;
        if (sysDepartment != null){
            sysDepartmentRespVo = new SysDepartmentRespVo();
            BeanUtils.copyProperties(sysDepartment, sysDepartmentRespVo);
        }
        
        return sysDepartmentRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysDepartmentRespVo> queryPageList(SysDepartmentReqVo sysDepartmentReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysDepartment转成SysDepartmentRespVo
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(sysDepartmentReqVo, sysDepartment);
        List<SysDepartment> sysDepartmentList = this.sysDepartmentMapper.queryAll(sysDepartment);
        
        PageInfo<SysDepartmentRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysDepartmentList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysDepartmentRespVo save(SysDepartmentReqVo sysDepartmentReqVo) {
        //将SysDepartmentReqVo转成SysDepartment
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(sysDepartmentReqVo, sysDepartment);
        this.sysDepartmentMapper.insert(sysDepartment);
        
        return this.queryById(sysDepartment.getId());
    }

    /**
     * 修改数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysDepartmentRespVo edit(SysDepartmentReqVo sysDepartmentReqVo) {
        //将SysDepartmentRespVo转成SysDepartment
        SysDepartment sysDepartment = new SysDepartment();
        BeanUtils.copyProperties(sysDepartmentReqVo, sysDepartment);
        this.sysDepartmentMapper.update(sysDepartment);
        
        return this.queryById(sysDepartment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysDepartmentMapper.deleteById(id) > 0;
    }
}