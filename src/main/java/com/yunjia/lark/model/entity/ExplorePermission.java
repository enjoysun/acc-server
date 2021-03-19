package com.yunjia.lark.model.entity;

import com.yunjia.lark.model.respvo.SysExplorerRespVo;
import com.yunjia.lark.model.respvo.SysInterfaceRespVo;
import com.yunjia.lark.model.respvo.SysMenuRespVo;
import lombok.Data;

import java.util.List;

/**
 * @Author myou
 * @Date 2021/3/16  5:31 下午
 * <p>
 * 角色拥有所有permission
 */
@Data
public class ExplorePermission {

    private SysExplorerRespVo sysExplorer;

    private List<SysInterfaceRespVo> sysInterface;

    private List<SysMenuRespVo> sysMenus;
}
