package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 角色表(SysRole)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:45:47
 */
@ApiModel("SysRoleRespVo")
@Data
public class SysRoleRespVo implements Serializable {

    private static final long serialVersionUID = -97569823199257190L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "角色编码")
    private String code;
    
    @ApiModelProperty(value = "角色名称")
    private String name;
    
    @ApiModelProperty(value = "状态 0:正常 1:暂无法使用(暂做扩展)")
    private Integer status;
    
    @ApiModelProperty(value = "用户备注")
    private String description;
    
    @ApiModelProperty(value = "角色等级")
    private Integer level;
    
    @ApiModelProperty(value = "父角色id")
    private Long pid;
    
    @ApiModelProperty(value = "角色序号")
    private Integer seq;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;
    
}