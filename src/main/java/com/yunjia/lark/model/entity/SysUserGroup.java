package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 用户——用户组中间表(SysUserGroup)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:44:57
 */
@Data
public class SysUserGroup implements Serializable {

    private static final long serialVersionUID = 698533101008529879L;
    
     private Long id;
    
     //用户id
     private Long uid;
    
     //用户组id
     private Long gid;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}