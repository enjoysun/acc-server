package com.yunjia.lark.model.reqvo;

import java.util.Date;
import com.yunjia.lark.model.system.ValidationGroups;
import lombok.Data;
import io.swagger.annotations.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:40:02
 */
@ApiModel("SysUserReqVo")
@Data
public class SysUserReqVo implements Serializable {

    private static final long serialVersionUID = -54520185631385931L;

    @ApiModelProperty(value = "$column.comment")
    @NotNull(groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    @Min(value = 1, groups = {ValidationGroups.Update.class, ValidationGroups.Delete.class})
    private Long id;

    @ApiModelProperty(value = "用户姓名")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String name;

    @ApiModelProperty(value = "用户性别")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer sex;

    @ApiModelProperty(value = "用户年龄")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer age;

    @ApiModelProperty(value = "用户联系电话")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String phone;

    @ApiModelProperty(value = "用户邮箱")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String email;

    @ApiModelProperty(value = "用户出生日期")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String birthday;

    @ApiModelProperty(value = "用户账号")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String account;

    @ApiModelProperty(value = "用户密码")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String password;

    @ApiModelProperty(value = "用户备注")
    @NotNull(groups = {ValidationGroups.Save.class})
    private String description;

    @ApiModelProperty(value = "账户登录状态 0:正常 1:登录失效(暂做扩展)")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer status;

    @ApiModelProperty(value = "删除状态 0:未删除 1:已删除")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer deleted;

    @ApiModelProperty(value = "账户状态 0:正常 1:锁定")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Integer locked;

    @ApiModelProperty(value = "所属部门")
    @NotNull(groups = {ValidationGroups.Save.class})
    private Long dptId;

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