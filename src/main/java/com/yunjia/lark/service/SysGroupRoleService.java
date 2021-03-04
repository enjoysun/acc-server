package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysGroupRoleReqVo;
import com.yunjia.lark.model.respvo.SysGroupRoleRespVo;
import com.github.pagehelper.*;

/**
 * 用户组角色表(SysGroupRole)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:46:23
 */
public interface SysGroupRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysGroupRoleRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysGroupRoleRespVo> queryPageList(SysGroupRoleReqVo sysGroupRoleReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @return 实例对象
     */
    SysGroupRoleRespVo save(SysGroupRoleReqVo sysGroupRoleReqVo);

    /**
     * 修改数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @return 实例对象
     */
    SysGroupRoleRespVo edit(SysGroupRoleReqVo sysGroupRoleReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}