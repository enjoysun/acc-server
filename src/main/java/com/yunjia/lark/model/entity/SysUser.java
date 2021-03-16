package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:40:02
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 106546686730165885L;
    
     private Long id;
    
     //用户姓名
     private String name;
    
     //用户性别
     private Integer sex;
    
     //用户年龄
     private Integer age;
    
     //用户联系电话
     private String phone;
    
     //用户邮箱
     private String email;
    
     //用户出生日期
     private String birthday;
    
     //用户账号
     private String account;
    
     //用户密码
     private String password;

     //盐值
     private String salt;
    
     //用户备注
     private String description;
    
     //账户登录状态 0:正常 1:登录失效(暂做扩展)
     private Integer status;
    
     //删除状态 0:未删除 1:已删除
     private Integer deleted;
    
     //账户状态 0:正常 1:锁定
     private Integer locked;
    
     //所属部门
     private Long dptId;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}