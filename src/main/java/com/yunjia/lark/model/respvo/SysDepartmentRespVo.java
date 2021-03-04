package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 部门表(SysDepartment)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:47
 */
@ApiModel("SysDepartmentRespVo")
@Data
public class SysDepartmentRespVo implements Serializable {

    private static final long serialVersionUID = -56961645782666062L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "部门名称")
    private String name;
    
    @ApiModelProperty(value = "部门等级")
    private Integer level;
    
    @ApiModelProperty(value = "上级部门id")
    private Long pid;
    
    @ApiModelProperty(value = "备注")
    private String description;
    
    @ApiModelProperty(value = "部门序号")
    private String seq;
    
    @ApiModelProperty(value = "所属组织")
    private Long orgId;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;
    
}