package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysDepartmentReqVo;
import com.yunjia.lark.model.respvo.SysDepartmentRespVo;
import com.github.pagehelper.*;

/**
 * 部门表(SysDepartment)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:46:47
 */
public interface SysDepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysDepartmentRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysDepartmentRespVo> queryPageList(SysDepartmentReqVo sysDepartmentReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @return 实例对象
     */
    SysDepartmentRespVo save(SysDepartmentReqVo sysDepartmentReqVo);

    /**
     * 修改数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @return 实例对象
     */
    SysDepartmentRespVo edit(SysDepartmentReqVo sysDepartmentReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}