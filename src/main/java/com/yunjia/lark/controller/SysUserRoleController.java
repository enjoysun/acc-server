package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysUserRoleReqVo;
import com.yunjia.lark.model.respvo.SysUserRoleRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysUserRoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 用户角色表(SysUserRole)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:44:48
 */
@Api(tags = "用户角色表(SysUserRole)")
@Validated
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserRoleService sysUserRoleService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 用户角色表")
    @ApiImplicitParam(name="id", value="SysUserRole id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysUserRoleRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysUserRoleService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 用户角色表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysUserRoleRespVo> queryPageList(@RequestBody SysUserRoleReqVo sysUserRoleReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysUserRoleService.queryPageList(sysUserRoleReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 用户角色表")
    @PostMapping(value = "/save")
    public SysUserRoleRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysUserRoleReqVo sysUserRoleReqVo) {
        return sysUserRoleService.save(sysUserRoleReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysUserRoleReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 用户角色表")
    @ApiImplicitParam(name="id",value="SysUserRole id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysUserRoleRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysUserRoleReqVo sysUserRoleReqVo) {
        return sysUserRoleService.edit(sysUserRoleReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 用户角色表")
    @ApiImplicitParam(name="id", value="SysUserRole id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysUserRoleService.deleteById(id);
    }

}