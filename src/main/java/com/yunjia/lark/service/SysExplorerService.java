package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysExplorerReqVo;
import com.yunjia.lark.model.respvo.SysExplorerRespVo;
import com.github.pagehelper.*;

/**
 * 资源控制表(SysExplorer)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:46:40
 */
public interface SysExplorerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysExplorerRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysExplorerReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysExplorerRespVo> queryPageList(SysExplorerReqVo sysExplorerReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysExplorerReqVo 实例对象
     * @return 实例对象
     */
    SysExplorerRespVo save(SysExplorerReqVo sysExplorerReqVo);

    /**
     * 修改数据
     *
     * @param sysExplorerReqVo 实例对象
     * @return 实例对象
     */
    SysExplorerRespVo edit(SysExplorerReqVo sysExplorerReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}