package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 接口表(SysInterface)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:14
 */
@Data
public class SysInterface implements Serializable {

    private static final long serialVersionUID = 883474521765674928L;
    
     private Long id;
    
     //资源id
     private Long eid;
    
     //接口名称
     private String name;
    
     //状态 0:正常 1:暂无法使用(暂做扩展)
     private Integer status;
    
     //资源备注
     private String description;
    
     //接口所属应用
     private String serviceName;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}