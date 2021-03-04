package com.yunjia.lark.model.reqvo;

import java.util.Date;
import com.yunjia.lark.model.system.ValidationGroups;
import lombok.Data;
import io.swagger.annotations.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户组角色表(SysGroupRole)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:23
 */
@ApiModel("SysGroupRoleReqVo")
@Data
public class SysGroupRoleReqVo implements Serializable {

    private static final long serialVersionUID = 179155097077097775L;

    @ApiModelProperty(value = "$column.comment")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Long id;

    @ApiModelProperty(value = "group_id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long gid;

    @ApiModelProperty(value = "role_id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long rid;

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