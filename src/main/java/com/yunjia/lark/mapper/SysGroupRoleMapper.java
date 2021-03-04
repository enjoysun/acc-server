package com.yunjia.lark.mapper;

import com.yunjia.lark.model.entity.SysGroupRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户组角色表(SysGroupRole)表数据库访问层
 *
 * @author gyli
 * @since 2021-03-04 17:46:23
 */
public interface SysGroupRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysGroupRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysGroupRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysGroupRole 实例对象
     * @return 对象列表
     */
    List<SysGroupRole> queryAll(SysGroupRole sysGroupRole);

    /**
     * 新增数据
     *
     * @param sysGroupRole 实例对象
     * @return 影响行数
     */
    int insert(SysGroupRole sysGroupRole);

    /**
     * 修改数据
     *
     * @param sysGroupRole 实例对象
     * @return 影响行数
     */
    int update(SysGroupRole sysGroupRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}