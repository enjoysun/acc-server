package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 用户角色表(SysUserRole)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:44:48
 */
@Data
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = -55844996862519896L;
    
     private Long id;
    
     //user_id
     private Long uid;
    
     //role_id
     private Long rid;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}