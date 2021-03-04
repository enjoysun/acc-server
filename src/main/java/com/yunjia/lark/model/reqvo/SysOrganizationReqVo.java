package com.yunjia.lark.model.reqvo;

import java.util.Date;
import com.yunjia.lark.model.system.ValidationGroups;
import lombok.Data;
import io.swagger.annotations.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 组织表(SysOrganization)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:45:56
 */
@ApiModel("SysOrganizationReqVo")
@Data
public class SysOrganizationReqVo implements Serializable {

    private static final long serialVersionUID = -20012554771228021L;

    @ApiModelProperty(value = "$column.comment")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Long id;

    @ApiModelProperty(value = "组织名称")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String name;

    @ApiModelProperty(value = "地址")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String address;

    @ApiModelProperty(value = "法人")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String legal;

    @ApiModelProperty(value = "备注")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String description;

    @ApiModelProperty(value = "联系电话")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String phone;

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