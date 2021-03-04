package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysGroupReqVo;
import com.yunjia.lark.model.respvo.SysGroupRespVo;
import com.github.pagehelper.*;

/**
 * 用户组(SysGroup)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:46:31
 */
public interface SysGroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysGroupRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysGroupReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysGroupRespVo> queryPageList(SysGroupReqVo sysGroupReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysGroupReqVo 实例对象
     * @return 实例对象
     */
    SysGroupRespVo save(SysGroupReqVo sysGroupReqVo);

    /**
     * 修改数据
     *
     * @param sysGroupReqVo 实例对象
     * @return 实例对象
     */
    SysGroupRespVo edit(SysGroupReqVo sysGroupReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}