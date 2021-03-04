package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 角色表(SysRole)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:45:47
 */
@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID = -87707758312386622L;
    
     private Long id;
    
     //角色编码
     private String code;
    
     //角色名称
     private String name;
    
     //状态 0:正常 1:暂无法使用(暂做扩展)
     private Integer status;
    
     //用户备注
     private String description;
    
     //角色等级
     private Integer level;
    
     //父角色id
     private Long pid;
    
     //角色序号
     private Integer seq;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}