package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysInterfaceReqVo;
import com.yunjia.lark.model.respvo.SysInterfaceRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysInterfaceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 接口表(SysInterface)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:46:14
 */
@Api(tags = "接口表(SysInterface)")
@Validated
@RestController
@RequestMapping("/sysInterface")
public class SysInterfaceController {
    /**
     * 服务对象
     */
    @Resource
    private SysInterfaceService sysInterfaceService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 接口表")
    @ApiImplicitParam(name="id", value="SysInterface id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysInterfaceRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysInterfaceService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 接口表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysInterfaceRespVo> queryPageList(@RequestBody SysInterfaceReqVo sysInterfaceReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysInterfaceService.queryPageList(sysInterfaceReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 接口表")
    @PostMapping(value = "/save")
    public SysInterfaceRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysInterfaceReqVo sysInterfaceReqVo) {
        return sysInterfaceService.save(sysInterfaceReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysInterfaceReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 接口表")
    @ApiImplicitParam(name="id",value="SysInterface id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysInterfaceRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysInterfaceReqVo sysInterfaceReqVo) {
        return sysInterfaceService.edit(sysInterfaceReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 接口表")
    @ApiImplicitParam(name="id", value="SysInterface id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysInterfaceService.deleteById(id);
    }

}