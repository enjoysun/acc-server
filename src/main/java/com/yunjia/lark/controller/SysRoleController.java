package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysRoleReqVo;
import com.yunjia.lark.model.respvo.SysRoleRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysRoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 角色表(SysRole)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:45:47
 */
@Api(tags = "角色表(SysRole)")
@Validated
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 角色表")
    @ApiImplicitParam(name="id", value="SysRole id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysRoleRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysRoleService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysRoleReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 角色表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysRoleRespVo> queryPageList(@RequestBody SysRoleReqVo sysRoleReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysRoleService.queryPageList(sysRoleReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysRoleReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 角色表")
    @PostMapping(value = "/save")
    public SysRoleRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysRoleReqVo sysRoleReqVo) {
        return sysRoleService.save(sysRoleReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysRoleReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 角色表")
    @ApiImplicitParam(name="id",value="SysRole id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysRoleRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysRoleReqVo sysRoleReqVo) {
        return sysRoleService.edit(sysRoleReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 角色表")
    @ApiImplicitParam(name="id", value="SysRole id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysRoleService.deleteById(id);
    }

}