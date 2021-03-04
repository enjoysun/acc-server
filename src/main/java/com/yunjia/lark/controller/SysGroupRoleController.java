package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysGroupRoleReqVo;
import com.yunjia.lark.model.respvo.SysGroupRoleRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysGroupRoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 用户组角色表(SysGroupRole)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:46:23
 */
@Api(tags = "用户组角色表(SysGroupRole)")
@Validated
@RestController
@RequestMapping("/sysGroupRole")
public class SysGroupRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysGroupRoleService sysGroupRoleService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 用户组角色表")
    @ApiImplicitParam(name="id", value="SysGroupRole id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysGroupRoleRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysGroupRoleService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 用户组角色表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysGroupRoleRespVo> queryPageList(@RequestBody SysGroupRoleReqVo sysGroupRoleReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysGroupRoleService.queryPageList(sysGroupRoleReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 用户组角色表")
    @PostMapping(value = "/save")
    public SysGroupRoleRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysGroupRoleReqVo sysGroupRoleReqVo) {
        return sysGroupRoleService.save(sysGroupRoleReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysGroupRoleReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 用户组角色表")
    @ApiImplicitParam(name="id",value="SysGroupRole id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysGroupRoleRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysGroupRoleReqVo sysGroupRoleReqVo) {
        return sysGroupRoleService.edit(sysGroupRoleReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 用户组角色表")
    @ApiImplicitParam(name="id", value="SysGroupRole id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysGroupRoleService.deleteById(id);
    }

}