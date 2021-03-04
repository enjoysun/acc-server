package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 组织表(SysOrganization)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:45:56
 */
@ApiModel("SysOrganizationRespVo")
@Data
public class SysOrganizationRespVo implements Serializable {

    private static final long serialVersionUID = 680707819910115189L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "组织名称")
    private String name;
    
    @ApiModelProperty(value = "地址")
    private String address;
    
    @ApiModelProperty(value = "法人")
    private String legal;
    
    @ApiModelProperty(value = "备注")
    private String description;
    
    @ApiModelProperty(value = "联系电话")
    private String phone;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;
    
}