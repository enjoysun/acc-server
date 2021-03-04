package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysOrganizationReqVo;
import com.yunjia.lark.model.respvo.SysOrganizationRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysOrganizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 组织表(SysOrganization)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:45:56
 */
@Api(tags = "组织表(SysOrganization)")
@Validated
@RestController
@RequestMapping("/sysOrganization")
public class SysOrganizationController {
    /**
     * 服务对象
     */
    @Resource
    private SysOrganizationService sysOrganizationService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 组织表")
    @ApiImplicitParam(name="id", value="SysOrganization id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysOrganizationRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysOrganizationService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 组织表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysOrganizationRespVo> queryPageList(@RequestBody SysOrganizationReqVo sysOrganizationReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysOrganizationService.queryPageList(sysOrganizationReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 组织表")
    @PostMapping(value = "/save")
    public SysOrganizationRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysOrganizationReqVo sysOrganizationReqVo) {
        return sysOrganizationService.save(sysOrganizationReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysOrganizationReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 组织表")
    @ApiImplicitParam(name="id",value="SysOrganization id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysOrganizationRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysOrganizationReqVo sysOrganizationReqVo) {
        return sysOrganizationService.edit(sysOrganizationReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 组织表")
    @ApiImplicitParam(name="id", value="SysOrganization id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysOrganizationService.deleteById(id);
    }

}