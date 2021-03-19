package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysRoleReqVo;
import com.yunjia.lark.model.respvo.SysRoleRespVo;
import com.github.pagehelper.*;

import java.util.List;

/**
 * 角色表(SysRole)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:45:47
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRoleRespVo queryById(Long id);


    List<SysRoleRespVo> queryAllRolesByUserId(Long id);

    /**
     * 查询多条数据
     *
     * @param sysRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysRoleRespVo> queryPageList(SysRoleReqVo sysRoleReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysRoleReqVo 实例对象
     * @return 实例对象
     */
    SysRoleRespVo save(SysRoleReqVo sysRoleReqVo);

    /**
     * 修改数据
     *
     * @param sysRoleReqVo 实例对象
     * @return 实例对象
     */
    SysRoleRespVo edit(SysRoleReqVo sysRoleReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}