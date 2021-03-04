package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 用户组角色表(SysGroupRole)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:23
 */
@Data
public class SysGroupRole implements Serializable {

    private static final long serialVersionUID = -42298833914356847L;
    
     private Long id;
    
     //group_id
     private Long gid;
    
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