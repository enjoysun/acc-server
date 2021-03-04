package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysGroupReqVo;
import com.yunjia.lark.model.respvo.SysGroupRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysGroupService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 用户组(SysGroup)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:46:31
 */
@Api(tags = "用户组(SysGroup)")
@Validated
@RestController
@RequestMapping("/sysGroup")
public class SysGroupController {
    /**
     * 服务对象
     */
    @Resource
    private SysGroupService sysGroupService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 用户组")
    @ApiImplicitParam(name="id", value="SysGroup id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysGroupRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysGroupService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysGroupReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 用户组")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysGroupRespVo> queryPageList(@RequestBody SysGroupReqVo sysGroupReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysGroupService.queryPageList(sysGroupReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysGroupReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 用户组")
    @PostMapping(value = "/save")
    public SysGroupRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysGroupReqVo sysGroupReqVo) {
        return sysGroupService.save(sysGroupReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysGroupReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 用户组")
    @ApiImplicitParam(name="id",value="SysGroup id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysGroupRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysGroupReqVo sysGroupReqVo) {
        return sysGroupService.edit(sysGroupReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 用户组")
    @ApiImplicitParam(name="id", value="SysGroup id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysGroupService.deleteById(id);
    }

}