package com.yunjia.lark.mapper;

import com.yunjia.lark.model.entity.SysDepartment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 部门表(SysDepartment)表数据库访问层
 *
 * @author gyli
 * @since 2021-03-04 17:46:47
 */
public interface SysDepartmentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysDepartment queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysDepartment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDepartment 实例对象
     * @return 对象列表
     */
    List<SysDepartment> queryAll(SysDepartment sysDepartment);

    /**
     * 新增数据
     *
     * @param sysDepartment 实例对象
     * @return 影响行数
     */
    int insert(SysDepartment sysDepartment);

    /**
     * 修改数据
     *
     * @param sysDepartment 实例对象
     * @return 影响行数
     */
    int update(SysDepartment sysDepartment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}