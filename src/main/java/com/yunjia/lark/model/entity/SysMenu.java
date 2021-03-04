package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 菜单表(SysMenu)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:03
 */
@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = -96734097420289508L;
    
     private Long id;
    
     //资源id
     private Long eid;
    
     //菜单名称
     private String name;
    
     //菜单矢量图标或地址
     private String icon;
    
     //状态 0:正常 1:暂无法使用(暂做扩展)
     private Integer status;
    
     //菜单备注
     private String description;
    
     //菜单连接地址
     private String href;
    
     //父菜单id
     private Long pid;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}