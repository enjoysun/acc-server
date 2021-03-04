package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 用户组(SysGroup)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:31
 */
@ApiModel("SysGroupRespVo")
@Data
public class SysGroupRespVo implements Serializable {

    private static final long serialVersionUID = 205991293984988023L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "用户组别名")
    private String name;
    
    @ApiModelProperty(value = "用户组备注")
    private String description;
    
    @ApiModelProperty(value = "状态 0:正常 1:暂无法使用(暂做扩展)")
    private Integer status;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;
    
}