package com.hjl.service;

import com.hjl.entity.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 根据账号查找管理员
     * @return List
     */
    List<Department> selectAll();

    /**
     * 新增部门
     * @param department
     * @return int
     */
    int insertDepartment(Department department);

    /**
     * 删除部门
     * @param id
     */
    void deleteDepartment(int id);
}
