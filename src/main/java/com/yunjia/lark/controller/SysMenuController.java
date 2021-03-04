package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysMenuReqVo;
import com.yunjia.lark.model.respvo.SysMenuRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysMenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 菜单表(SysMenu)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:46:03
 */
@Api(tags = "菜单表(SysMenu)")
@Validated
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 菜单表")
    @ApiImplicitParam(name="id", value="SysMenu id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysMenuRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysMenuService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysMenuReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 菜单表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysMenuRespVo> queryPageList(@RequestBody SysMenuReqVo sysMenuReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysMenuService.queryPageList(sysMenuReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysMenuReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 菜单表")
    @PostMapping(value = "/save")
    public SysMenuRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysMenuReqVo sysMenuReqVo) {
        return sysMenuService.save(sysMenuReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysMenuReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 菜单表")
    @ApiImplicitParam(name="id",value="SysMenu id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysMenuRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysMenuReqVo sysMenuReqVo) {
        return sysMenuService.edit(sysMenuReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 菜单表")
    @ApiImplicitParam(name="id", value="SysMenu id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysMenuService.deleteById(id);
    }

}