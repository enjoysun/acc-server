package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysOrganizationReqVo;
import com.yunjia.lark.model.respvo.SysOrganizationRespVo;
import com.github.pagehelper.*;

/**
 * 组织表(SysOrganization)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:45:56
 */
public interface SysOrganizationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOrganizationRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysOrganizationRespVo> queryPageList(SysOrganizationReqVo sysOrganizationReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @return 实例对象
     */
    SysOrganizationRespVo save(SysOrganizationReqVo sysOrganizationReqVo);

    /**
     * 修改数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @return 实例对象
     */
    SysOrganizationRespVo edit(SysOrganizationReqVo sysOrganizationReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}