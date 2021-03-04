package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 部门表(SysDepartment)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:47
 */
@Data
public class SysDepartment implements Serializable {

    private static final long serialVersionUID = -49153413286281437L;
    
     private Long id;
    
     //部门名称
     private String name;
    
     //部门等级
     private Integer level;
    
     //上级部门id
     private Long pid;
    
     //备注
     private String description;
    
     //部门序号
     private String seq;
    
     //所属组织
     private Long orgId;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}