package com.yunjia.lark.model.reqvo;

import java.util.Date;
import com.yunjia.lark.model.system.ValidationGroups;
import lombok.Data;
import io.swagger.annotations.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户——用户组中间表(SysUserGroup)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:44:57
 */
@ApiModel("SysUserGroupReqVo")
@Data
public class SysUserGroupReqVo implements Serializable {

    private static final long serialVersionUID = 844769279687601749L;

    @ApiModelProperty(value = "$column.comment")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Long id;

    @ApiModelProperty(value = "用户id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long uid;

    @ApiModelProperty(value = "用户组id")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long gid;

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