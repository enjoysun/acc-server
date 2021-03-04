package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysMenu;
import com.yunjia.lark.model.reqvo.SysMenuReqVo;
import com.yunjia.lark.model.respvo.SysMenuRespVo;
import com.yunjia.lark.mapper.SysMenuMapper;
import com.yunjia.lark.service.SysMenuService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 菜单表(SysMenu)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:46:03
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysMenuRespVo queryById(Long id) {
        SysMenu sysMenu = this.sysMenuMapper.queryById(id);
        
        //将SysMenu转成SysMenuRespVo
        SysMenuRespVo sysMenuRespVo = null;
        if (sysMenu != null){
            sysMenuRespVo = new SysMenuRespVo();
            BeanUtils.copyProperties(sysMenu, sysMenuRespVo);
        }
        
        return sysMenuRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysMenuReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysMenuRespVo> queryPageList(SysMenuReqVo sysMenuReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysMenu转成SysMenuRespVo
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuReqVo, sysMenu);
        List<SysMenu> sysMenuList = this.sysMenuMapper.queryAll(sysMenu);
        
        PageInfo<SysMenuRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysMenuList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysMenuReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenuRespVo save(SysMenuReqVo sysMenuReqVo) {
        //将SysMenuReqVo转成SysMenu
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuReqVo, sysMenu);
        this.sysMenuMapper.insert(sysMenu);
        
        return this.queryById(sysMenu.getId());
    }

    /**
     * 修改数据
     *
     * @param sysMenuReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenuRespVo edit(SysMenuReqVo sysMenuReqVo) {
        //将SysMenuRespVo转成SysMenu
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuReqVo, sysMenu);
        this.sysMenuMapper.update(sysMenu);
        
        return this.queryById(sysMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysMenuMapper.deleteById(id) > 0;
    }
}