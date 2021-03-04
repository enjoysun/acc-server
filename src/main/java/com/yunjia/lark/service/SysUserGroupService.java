package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysUserGroupReqVo;
import com.yunjia.lark.model.respvo.SysUserGroupRespVo;
import com.github.pagehelper.*;

/**
 * 用户——用户组中间表(SysUserGroup)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:44:57
 */
public interface SysUserGroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserGroupRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysUserGroupRespVo> queryPageList(SysUserGroupReqVo sysUserGroupReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @return 实例对象
     */
    SysUserGroupRespVo save(SysUserGroupReqVo sysUserGroupReqVo);

    /**
     * 修改数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @return 实例对象
     */
    SysUserGroupRespVo edit(SysUserGroupReqVo sysUserGroupReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}