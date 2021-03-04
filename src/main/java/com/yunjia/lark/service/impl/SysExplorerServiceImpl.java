package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysExplorer;
import com.yunjia.lark.model.reqvo.SysExplorerReqVo;
import com.yunjia.lark.model.respvo.SysExplorerRespVo;
import com.yunjia.lark.mapper.SysExplorerMapper;
import com.yunjia.lark.service.SysExplorerService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 资源控制表(SysExplorer)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:46:40
 */
@Service("sysExplorerService")
public class SysExplorerServiceImpl implements SysExplorerService {

    @Resource
    private SysExplorerMapper sysExplorerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysExplorerRespVo queryById(Long id) {
        SysExplorer sysExplorer = this.sysExplorerMapper.queryById(id);
        
        //将SysExplorer转成SysExplorerRespVo
        SysExplorerRespVo sysExplorerRespVo = null;
        if (sysExplorer != null){
            sysExplorerRespVo = new SysExplorerRespVo();
            BeanUtils.copyProperties(sysExplorer, sysExplorerRespVo);
        }
        
        return sysExplorerRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysExplorerReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysExplorerRespVo> queryPageList(SysExplorerReqVo sysExplorerReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysExplorer转成SysExplorerRespVo
        SysExplorer sysExplorer = new SysExplorer();
        BeanUtils.copyProperties(sysExplorerReqVo, sysExplorer);
        List<SysExplorer> sysExplorerList = this.sysExplorerMapper.queryAll(sysExplorer);
        
        PageInfo<SysExplorerRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysExplorerList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysExplorerReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysExplorerRespVo save(SysExplorerReqVo sysExplorerReqVo) {
        //将SysExplorerReqVo转成SysExplorer
        SysExplorer sysExplorer = new SysExplorer();
        BeanUtils.copyProperties(sysExplorerReqVo, sysExplorer);
        this.sysExplorerMapper.insert(sysExplorer);
        
        return this.queryById(sysExplorer.getId());
    }

    /**
     * 修改数据
     *
     * @param sysExplorerReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysExplorerRespVo edit(SysExplorerReqVo sysExplorerReqVo) {
        //将SysExplorerRespVo转成SysExplorer
        SysExplorer sysExplorer = new SysExplorer();
        BeanUtils.copyProperties(sysExplorerReqVo, sysExplorer);
        this.sysExplorerMapper.update(sysExplorer);
        
        return this.queryById(sysExplorer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysExplorerMapper.deleteById(id) > 0;
    }
}