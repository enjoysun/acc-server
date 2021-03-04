package com.yunjia.lark.controller;

import com.yunjia.lark.model.reqvo.SysDepartmentReqVo;
import com.yunjia.lark.model.respvo.SysDepartmentRespVo;
import com.yunjia.lark.model.system.ValidationGroups;
import com.yunjia.lark.service.SysDepartmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import com.github.pagehelper.*;

import javax.validation.constraints.Min;
import javax.annotation.Resource;

/**
 * 部门表(SysDepartment)表控制层
 *
 * @author gyli
 * @since 2021-03-04 17:46:47
 */
@Api(tags = "部门表(SysDepartment)")
@Validated
@RestController
@RequestMapping("/sysDepartment")
public class SysDepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private SysDepartmentService sysDepartmentService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "通过id查询单条数据 部门表")
    @ApiImplicitParam(name="id", value="SysDepartment id", dataType="Long", paramType = "path", required=true)
    @GetMapping(value = "/queryById/{id}")
    public SysDepartmentRespVo queryById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return this.sysDepartmentService.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @param pageNum 页数
     * @param pageSize 每页条数
     * @return 对象列表
     */
    @ApiOperation(value = "查询多条数据 部门表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum", value="页数", dataType="int", paramType = "path", required=true),
            @ApiImplicitParam(name="pageSize", value="查询条数", dataType="int", paramType = "path", required=true)
            })
    @PostMapping(value = "/queryPageList/{pageNum}/{pageSize}")
    public PageInfo<SysDepartmentRespVo> queryPageList(@RequestBody SysDepartmentReqVo sysDepartmentReqVo, @PathVariable(value = "pageNum") int pageNum, @PathVariable(value = "pageSize") int pageSize) {
        return sysDepartmentService.queryPageList(sysDepartmentReqVo, pageNum, pageSize);
    }
    
    /**
     * 新增数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "新增数据 部门表")
    @PostMapping(value = "/save")
    public SysDepartmentRespVo save(@Validated(ValidationGroups.Save.class) @RequestBody SysDepartmentReqVo sysDepartmentReqVo) {
        return sysDepartmentService.save(sysDepartmentReqVo);
    }
    
    /**
     * 修改数据
     *
     * @param sysDepartmentReqVo 实例对象
     * @return 实例对象
     */
    @ApiOperation(value = "修改数据 部门表")
    @ApiImplicitParam(name="id",value="SysDepartment id",dataType="Long", paramType = "body", required=true)
    @PatchMapping(value = "/edit")
    public SysDepartmentRespVo edit(@Validated(ValidationGroups.Update.class) @RequestBody SysDepartmentReqVo sysDepartmentReqVo) {
        return sysDepartmentService.edit(sysDepartmentReqVo);
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation(value = "通过主键删除数据 部门表")
    @ApiImplicitParam(name="id", value="SysDepartment id", dataType="Long", paramType = "path", required=true)
    @DeleteMapping(value = "/deleteById/{id}")
    public boolean deleteById(@Min(value = 1) @PathVariable(value = "id") Long id) {
        return sysDepartmentService.deleteById(id);
    }

}