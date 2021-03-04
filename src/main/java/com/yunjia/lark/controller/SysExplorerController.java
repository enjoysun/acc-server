package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysExplorerReqVo;
import com.yunjia.lark.model.respvo.SysExplorerRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysExplorerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 资源控制表(SysExplorer)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:46:40
 */
@Api(tags = "资源控制表(SysExplorer)")
@Validated
@RestController
@RequestMapping("/sysExplorer")
public class SysExplorerController {
    /**
     * 服务对象
     */
    @Resource
    private SysExplorerService sysExplorerService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 资源控制表")
    @ApiImplicitParam(name="id", value="SysExplorer id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysExplorerRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysExplorerService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysExplorerReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 资源控制表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysExplorerRespVo> queryPageList(@RequestBody SysExplorerReqVo sysExplorerReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysExplorerService.queryPageList(sysExplorerReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysExplorerReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 资源控制表")
    @PostMapping(value = "/save")
    public SysExplorerRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysExplorerReqVo sysExplorerReqVo) {
        return sysExplorerService.save(sysExplorerReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysExplorerReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 资源控制表")
    @ApiImplicitParam(name="id",value="SysExplorer id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysExplorerRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysExplorerReqVo sysExplorerReqVo) {
        return sysExplorerService.edit(sysExplorerReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 资源控制表")
    @ApiImplicitParam(name="id", value="SysExplorer id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysExplorerService.deleteById(id);
    }

}