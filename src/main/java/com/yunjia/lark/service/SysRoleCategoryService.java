package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysRoleCategoryReqVo;
import com.yunjia.lark.model.respvo.SysRoleCategoryRespVo;
import com.github.pagehelper.*;

/**
 * 角色类别表(SysRoleCategory)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:45:04
 */
public interface SysRoleCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRoleCategoryRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysRoleCategoryRespVo> queryPageList(SysRoleCategoryReqVo sysRoleCategoryReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @return 实例对象
     */
    SysRoleCategoryRespVo save(SysRoleCategoryReqVo sysRoleCategoryReqVo);

    /**
     * 修改数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @return 实例对象
     */
    SysRoleCategoryRespVo edit(SysRoleCategoryReqVo sysRoleCategoryReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}