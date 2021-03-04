package com.yunjia.lark.model.reqvo;

import java.util.Date;
import com.yunjia.lark.model.system.ValidationGroups;
import lombok.Data;
import io.swagger.annotations.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 部门表(SysDepartment)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:47
 */
@ApiModel("SysDepartmentReqVo")
@Data
public class SysDepartmentReqVo implements Serializable {

    private static final long serialVersionUID = 264248933498626304L;

    @ApiModelProperty(value = "$column.comment")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Long id;

    @ApiModelProperty(value = "部门名称")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String name;

    @ApiModelProperty(value = "部门等级")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer level;

    @ApiModelProperty(value = "上级部门id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long pid;

    @ApiModelProperty(value = "备注")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String description;

    @ApiModelProperty(value = "部门序号")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String seq;

    @ApiModelProperty(value = "所属组织")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long orgId;

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