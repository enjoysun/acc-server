package com.yunjia.lark.mapper;

import com.yunjia.lark.model.entity.SysOrganization;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 组织表(SysOrganization)表数据库访问层
 *
 * @author gyli
 * @since 2021-03-04 17:45:56
 */
public interface SysOrganizationMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOrganization queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOrganization> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysOrganization 实例对象
     * @return 对象列表
     */
    List<SysOrganization> queryAll(SysOrganization sysOrganization);

    /**
     * 新增数据
     *
     * @param sysOrganization 实例对象
     * @return 影响行数
     */
    int insert(SysOrganization sysOrganization);

    /**
     * 修改数据
     *
     * @param sysOrganization 实例对象
     * @return 影响行数
     */
    int update(SysOrganization sysOrganization);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}