package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysInterfaceReqVo;
import com.yunjia.lark.model.respvo.SysInterfaceRespVo;
import com.github.pagehelper.*;

/**
 * 接口表(SysInterface)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:46:14
 */
public interface SysInterfaceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysInterfaceRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysInterfaceRespVo> queryPageList(SysInterfaceReqVo sysInterfaceReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @return 实例对象
     */
    SysInterfaceRespVo save(SysInterfaceReqVo sysInterfaceReqVo);

    /**
     * 修改数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @return 实例对象
     */
    SysInterfaceRespVo edit(SysInterfaceReqVo sysInterfaceReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}