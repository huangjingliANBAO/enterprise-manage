package com.hjl.dao;

import com.hjl.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    /**
     * 查询所有部门
     * @return List<Department>
     * @throws SQLException
     */
    List<Department> selectAll()throws SQLException;

    /**
     * 新增部门
     * @param department
     * @return int
     * @throws SQLException
     */
    int insertDepartment(Department department) throws SQLException;

    /**
     * 点击删除按钮删除部门
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteDepartmentById (int id) throws SQLException;

}
