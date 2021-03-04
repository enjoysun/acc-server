package com.yunjia.lark.model.reqvo;

import java.util.Date;
import com.yunjia.lark.model.system.ValidationGroups;
import lombok.Data;
import io.swagger.annotations.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 菜单表(SysMenu)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:03
 */
@ApiModel("SysMenuReqVo")
@Data
public class SysMenuReqVo implements Serializable {

    private static final long serialVersionUID = 444892539985455175L;

    @ApiModelProperty(value = "$column.comment")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Long id;

    @ApiModelProperty(value = "资源id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long eid;

    @ApiModelProperty(value = "菜单名称")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String name;

    @ApiModelProperty(value = "菜单矢量图标或地址")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String icon;

    @ApiModelProperty(value = "状态 0:正常 1:暂无法使用(暂做扩展)")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer status;

    @ApiModelProperty(value = "菜单备注")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String description;

    @ApiModelProperty(value = "菜单连接地址")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String href;

    @ApiModelProperty(value = "父菜单id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long pid;

    @ApiModelProperty(value = "创建人")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String createdBy;

    @ApiModelProperty(value = "修改人")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String updatedBy;

    @ApiModelProperty(value = "创建时间")
    private Date ctime;

    @ApiModelProperty(value = "更新时间")
    private Date utime;

}