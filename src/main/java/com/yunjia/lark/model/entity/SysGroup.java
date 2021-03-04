package com.yunjia.lark.model.entity;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * 用户组(SysGroup)实体类
 *
 * @author gyli
 * @since 2021-03-04 17:46:31
 */
@Data
public class SysGroup implements Serializable {

    private static final long serialVersionUID = -85341898414028962L;
    
     private Long id;
    
     //用户组别名
     private String name;
    
     //用户组备注
     private String description;
    
     //状态 0:正常 1:暂无法使用(暂做扩展)
     private Integer status;
    
     //创建人
     private String createdBy;
    
     //修改人
     private String updatedBy;
    
     //创建时间
     private Date ctime;
    
     //更新时间
     private Date utime;
    
}