package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 角色类别表(SysRoleCategory)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:45:04
 */
@Data
public class SysRoleCategory implements Serializable {

    private static final long serialVersionUID = -35260243814259094L;
    
     private Long id;
    
     //角色id
     private Long rid;
    
     //角色类别名称
     private String name;
    
     //状态 0:正常 1:暂无法使用(暂做扩展)
     private Integer status;
    
     //用户备注
     private String description;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}