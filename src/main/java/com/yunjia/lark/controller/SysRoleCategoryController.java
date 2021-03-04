package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysRoleCategoryReqVo;
import com.yunjia.lark.model.respvo.SysRoleCategoryRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysRoleCategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 角色类别表(SysRoleCategory)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:45:04
 */
@Api(tags = "角色类别表(SysRoleCategory)")
@Validated
@RestController
@RequestMapping("/sysRoleCategory")
public class SysRoleCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleCategoryService sysRoleCategoryService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 角色类别表")
    @ApiImplicitParam(name="id", value="SysRoleCategory id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysRoleCategoryRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysRoleCategoryService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 角色类别表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysRoleCategoryRespVo> queryPageList(@RequestBody SysRoleCategoryReqVo sysRoleCategoryReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysRoleCategoryService.queryPageList(sysRoleCategoryReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 角色类别表")
    @PostMapping(value = "/save")
    public SysRoleCategoryRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysRoleCategoryReqVo sysRoleCategoryReqVo) {
        return sysRoleCategoryService.save(sysRoleCategoryReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysRoleCategoryReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 角色类别表")
    @ApiImplicitParam(name="id",value="SysRoleCategory id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysRoleCategoryRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysRoleCategoryReqVo sysRoleCategoryReqVo) {
        return sysRoleCategoryService.edit(sysRoleCategoryReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 角色类别表")
    @ApiImplicitParam(name="id", value="SysRoleCategory id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysRoleCategoryService.deleteById(id);
    }

}