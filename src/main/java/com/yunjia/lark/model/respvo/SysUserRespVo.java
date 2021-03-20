package com.yunjia.lark.model.respvo;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.*;
import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:40:02
 */
@ApiModel("SysUserRespVo")
@Data
public class SysUserRespVo implements Serializable {

    private static final long serialVersionUID = -31687666314357153L;
    
    @ApiModelProperty(value = "$column.comment")
    private Long id;
    
    @ApiModelProperty(value = "用户姓名")
    private String name;
    
    @ApiModelProperty(value = "用户性别")
    private Integer sex;
    
    @ApiModelProperty(value = "用户年龄")
    private Integer age;
    
    @ApiModelProperty(value = "用户联系电话")
    private String phone;
    
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    
    @ApiModelProperty(value = "用户出生日期")
    private String birthday;
    
    @ApiModelProperty(value = "用户账号")
    private String account;
    
    @ApiModelProperty(value = "用户密码")
    private transient String password;
    
    @ApiModelProperty(value = "用户备注")
    private String description;
    
    @ApiModelProperty(value = "账户登录状态 0:正常 1:登录失效(暂做扩展)")
    private Integer status;
    
    @ApiModelProperty(value = "删除状态 0:未删除 1:已删除")
    private Integer deleted;
    
    @ApiModelProperty(value = "账户状态 0:正常 1:锁定")
    private Integer locked;
    
    @ApiModelProperty(value = "所属部门")
    private Long dptId;
    
    @ApiModelProperty(value = "创建人")
    private String createdBy;
    
    @ApiModelProperty(value = "修改人")
    private String updatedBy;
    
    @ApiModelProperty(value = "创建时间")
    private Date ctime;
    
    @ApiModelProperty(value = "更新时间")
    private Date utime;


    private transient String salt;
    
}