package com.yunjia.lark.mapper;

import com.yunjia.lark.model.entity.SysRoleCategory;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色类别表(SysRoleCategory)表数据库访问层
 *
 * @author gyli
 * @since 2021-03-04 17:45:04
 */
public interface SysRoleCategoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRoleCategory queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysRoleCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleCategory 实例对象
     * @return 对象列表
     */
    List<SysRoleCategory> queryAll(SysRoleCategory sysRoleCategory);

    /**
     * 新增数据
     *
     * @param sysRoleCategory 实例对象
     * @return 影响行数
     */
    int insert(SysRoleCategory sysRoleCategory);

    /**
     * 修改数据
     *
     * @param sysRoleCategory 实例对象
     * @return 影响行数
     */
    int update(SysRoleCategory sysRoleCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}