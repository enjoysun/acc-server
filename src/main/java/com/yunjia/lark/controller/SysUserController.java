package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysUserReqVo;
import com.yunjia.lark.model.respvo.SysUserRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 用户表(SysUser)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:40:02
 */
@Api(tags = "用户表(SysUser)")
@Validated
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 用户表")
    @ApiImplicitParam(name="id", value="SysUser id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysUserRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysUserService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysUserReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 用户表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysUserRespVo> queryPageList(@RequestBody SysUserReqVo sysUserReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysUserService.queryPageList(sysUserReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysUserReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 用户表")
    @PostMapping(value = "/save")
    public SysUserRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysUserReqVo sysUserReqVo) {
        return sysUserService.save(sysUserReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysUserReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 用户表")
    @ApiImplicitParam(name="id",value="SysUser id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysUserRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysUserReqVo sysUserReqVo) {
        return sysUserService.edit(sysUserReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 用户表")
    @ApiImplicitParam(name="id", value="SysUser id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysUserService.deleteById(id);
    }

}