package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 用户组角色表(SysGroupRole)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:23
 */
@ApiModel("SysGroupRoleRespVo")
@Data
public class SysGroupRoleRespVo implements Serializable {

    private static final long serialVersionUID = 457451235361585627L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "group_id")
    private Long gid;
    
    @ApiModelProperty(value = "role_id")
    private Long rid;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;
    
}