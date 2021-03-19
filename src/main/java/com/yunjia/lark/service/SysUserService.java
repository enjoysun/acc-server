package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysUserReqVo;
import com.yunjia.lark.model.respvo.SysRoleRespVo;
import com.yunjia.lark.model.respvo.SysUserRespVo;
import com.github.pagehelper.*;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:40:02
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserRespVo queryById(Long id);

    /**
     * 通过ID查询单条数据
     *
     * @param name
     * @return 用户名或者账号
     */
    SysUserRespVo queryByUserNameOrAccount(String name);

    /**
     * 查询多条数据
     *
     * @param sysUserReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysUserRespVo> queryPageList(SysUserReqVo sysUserReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysUserReqVo 实例对象
     * @return 实例对象
     */
    SysUserRespVo save(SysUserReqVo sysUserReqVo);

    /**
     * 修改数据
     *
     * @param sysUserReqVo 实例对象
     * @return 实例对象
     */
    SysUserRespVo edit(SysUserReqVo sysUserReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}