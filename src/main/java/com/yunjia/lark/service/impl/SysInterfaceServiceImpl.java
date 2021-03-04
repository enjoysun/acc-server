package com.yunjia.lark.service.impl;

import com.yunjia.lark.model.entity.SysInterface;
import com.yunjia.lark.model.reqvo.SysInterfaceReqVo;
import com.yunjia.lark.model.respvo.SysInterfaceRespVo;
import com.yunjia.lark.mapper.SysInterfaceMapper;
import com.yunjia.lark.service.SysInterfaceService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.*;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.annotation.Resource;

/**
 * 接口表(SysInterface)表服务实现类
 *
 * @author gyli
 * @since 2021-03-04 17:46:14
 */
@Service("sysInterfaceService")
public class SysInterfaceServiceImpl implements SysInterfaceService {

    @Resource
    private SysInterfaceMapper sysInterfaceMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysInterfaceRespVo queryById(Long id) {
        SysInterface sysInterface = this.sysInterfaceMapper.queryById(id);
        
        //将SysInterface转成SysInterfaceRespVo
        SysInterfaceRespVo sysInterfaceRespVo = null;
        if (sysInterface != null){
            sysInterfaceRespVo = new SysInterfaceRespVo();
            BeanUtils.copyProperties(sysInterface, sysInterfaceRespVo);
        }
        
        return sysInterfaceRespVo;
    }

    /**
     * 查询多条数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @Override
    public PageInfo<SysInterfaceRespVo> queryPageList(SysInterfaceReqVo sysInterfaceReqVo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //将SysInterface转成SysInterfaceRespVo
        SysInterface sysInterface = new SysInterface();
        BeanUtils.copyProperties(sysInterfaceReqVo, sysInterface);
        List<SysInterface> sysInterfaceList = this.sysInterfaceMapper.queryAll(sysInterface);
        
        PageInfo<SysInterfaceRespVo> pageInfo = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(sysInterfaceList), pageInfo);
        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysInterfaceRespVo save(SysInterfaceReqVo sysInterfaceReqVo) {
        //将SysInterfaceReqVo转成SysInterface
        SysInterface sysInterface = new SysInterface();
        BeanUtils.copyProperties(sysInterfaceReqVo, sysInterface);
        this.sysInterfaceMapper.insert(sysInterface);
        
        return this.queryById(sysInterface.getId());
    }

    /**
     * 修改数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @return 实例对象
     */
    @Override
    public SysInterfaceRespVo edit(SysInterfaceReqVo sysInterfaceReqVo) {
        //将SysInterfaceRespVo转成SysInterface
        SysInterface sysInterface = new SysInterface();
        BeanUtils.copyProperties(sysInterfaceReqVo, sysInterface);
        this.sysInterfaceMapper.update(sysInterface);
        
        return this.queryById(sysInterface.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysInterfaceMapper.deleteById(id) > 0;
    }
}