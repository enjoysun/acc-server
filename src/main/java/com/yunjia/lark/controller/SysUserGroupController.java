package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysUserGroupReqVo;
import com.yunjia.lark.model.respvo.SysUserGroupRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysUserGroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 用户——用户组中间表(SysUserGroup)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:44:57
 */
@Api(tags = "用户——用户组中间表(SysUserGroup)")
@Validated
@RestController
@RequestMapping("/sysUserGroup")
public class SysUserGroupController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserGroupService sysUserGroupService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 用户——用户组中间表")
    @ApiImplicitParam(name="id", value="SysUserGroup id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysUserGroupRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysUserGroupService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 用户——用户组中间表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysUserGroupRespVo> queryPageList(@RequestBody SysUserGroupReqVo sysUserGroupReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysUserGroupService.queryPageList(sysUserGroupReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 用户——用户组中间表")
    @PostMapping(value = "/save")
    public SysUserGroupRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysUserGroupReqVo sysUserGroupReqVo) {
        return sysUserGroupService.save(sysUserGroupReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysUserGroupReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 用户——用户组中间表")
    @ApiImplicitParam(name="id",value="SysUserGroup id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysUserGroupRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysUserGroupReqVo sysUserGroupReqVo) {
        return sysUserGroupService.edit(sysUserGroupReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 用户——用户组中间表")
    @ApiImplicitParam(name="id", value="SysUserGroup id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysUserGroupService.deleteById(id);
    }

}