package com.hjl.service.impl;

import com.hjl.dao.DepartmentDAO;
import com.hjl.entity.Department;
import com.hjl.factory.DAOFactory;
import com.hjl.service.DepartmentService;
import java.sql.SQLException;
import java.util.List;


public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO =
            DAOFactory.getDepartmentInstance();

    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.selectAll();
        } catch (SQLException e) {
            System.out.println("查询院系信息出现异常");
        }
        return departmentList;
    }

    @Override
    public int insertDepartment(Department department) {
        int n = 0;
        try {
            n = departmentDAO.insertDepartment(department);
        } catch (SQLException e) {
            System.out.println("新增院系信息出现异常");
        }
        return n;
    }

    @Override
    public void deleteDepartment(int id) {
        try {
            departmentDAO.deleteDepartmentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
