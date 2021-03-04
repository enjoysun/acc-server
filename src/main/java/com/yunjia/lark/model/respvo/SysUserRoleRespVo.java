package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 用户角色表(SysUserRole)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:44:48
 */
@ApiModel("SysUserRoleRespVo")
@Data
public class SysUserRoleRespVo implements Serializable {

    private static final long serialVersionUID = -39385615064688913L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "user_id")
    private Long uid;
    
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