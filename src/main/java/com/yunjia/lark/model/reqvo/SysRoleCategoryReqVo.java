package com.yunjia.lark.model.reqvo;

import java.util.Date;
import com.yunjia.lark.model.system.ValidationGroups;
import lombok.Data;
import io.swagger.annotations.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 角色类别表(SysRoleCategory)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:45:04
 */
@ApiModel("SysRoleCategoryReqVo")
@Data
public class SysRoleCategoryReqVo implements Serializable {

    private static final long serialVersionUID = 304343878161681499L;

    @ApiModelProperty(value = "$column.comment")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Long id;

    @ApiModelProperty(value = "角色id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long rid;

    @ApiModelProperty(value = "角色类别名称")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String name;

    @ApiModelProperty(value = "状态 0:正常 1:暂无法使用(暂做扩展)")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer status;

    @ApiModelProperty(value = "用户备注")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String description;

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