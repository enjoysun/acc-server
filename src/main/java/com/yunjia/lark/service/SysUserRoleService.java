package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysUserRoleReqVo;
import com.yunjia.lark.model.respvo.SysUserRoleRespVo;
import com.github.pagehelper.*;

/**
 * 用户角色表(SysUserRole)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:44:48
 */
public interface SysUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRoleRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysUserRoleRespVo> queryPageList(SysUserRoleReqVo sysUserRoleReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @return 实例对象
     */
    SysUserRoleRespVo save(SysUserRoleReqVo sysUserRoleReqVo);

    /**
     * 修改数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @return 实例对象
     */
    SysUserRoleRespVo edit(SysUserRoleReqVo sysUserRoleReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}