package com.yunjia.lark.service;

import com.yunjia.lark.model.reqvo.SysMenuReqVo;
import com.yunjia.lark.model.respvo.SysMenuRespVo;
import com.github.pagehelper.*;

/**
 * 菜单表(SysMenu)表服务接口
 *
 * @author gyli
 * @since 2021-03-04 17:46:03
 */
public interface SysMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysMenuRespVo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param sysMenuReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    PageInfo<SysMenuRespVo> queryPageList(SysMenuReqVo sysMenuReqVo, int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param sysMenuReqVo 实例对象
     * @return 实例对象
     */
    SysMenuRespVo save(SysMenuReqVo sysMenuReqVo);

    /**
     * 修改数据
     *
     * @param sysMenuReqVo 实例对象
     * @return 实例对象
     */
    SysMenuRespVo edit(SysMenuReqVo sysMenuReqVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}