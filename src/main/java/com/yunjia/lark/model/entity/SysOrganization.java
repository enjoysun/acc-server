package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 组织表(SysOrganization)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:45:56
 */
@Data
public class SysOrganization implements Serializable {

    private static final long serialVersionUID = -85309640669098287L;
    
     private Long id;
    
     //组织名称
     private String name;
    
     //地址
     private String address;
    
     //法人
     private String legal;
    
     //备注
     private String description;
    
     //联系电话
     private String phone;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}