package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 菜单表(SysMenu)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:03
 */
@ApiModel("SysMenuRespVo")
@Data
public class SysMenuRespVo implements Serializable {

    private static final long serialVersionUID = -27202101401273441L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "资源id")
    private Long eid;
    
    @ApiModelProperty(value = "菜单名称")
    private String name;
    
    @ApiModelProperty(value = "菜单矢量图标或地址")
    private String icon;
    
    @ApiModelProperty(value = "状态 0:正常 1:暂无法使用(暂做扩展)")
    private Integer status;
    
    @ApiModelProperty(value = "菜单备注")
    private String description;
    
    @ApiModelProperty(value = "菜单连接地址")
    private String href;
    
    @ApiModelProperty(value = "父菜单id")
    private Long pid;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;
    
}