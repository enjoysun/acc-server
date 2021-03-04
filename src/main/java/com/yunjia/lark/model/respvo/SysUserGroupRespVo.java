package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 用户——用户组中间表(SysUserGroup)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:44:57
 */
@ApiModel("SysUserGroupRespVo")
@Data
public class SysUserGroupRespVo implements Serializable {

    private static final long serialVersionUID = 505727144391807649L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "用户id")
    private Long uid;
    
    @ApiModelProperty(value = "用户组id")
    private Long gid;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;
    
}