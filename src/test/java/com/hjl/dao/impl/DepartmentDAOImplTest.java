package com.hjl.dao.impl;

import com.hjl.dao.DepartmentDAO;
import com.hjl.entity.Department;
import com.hjl.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDAOImplTest {
 private DepartmentDAO departmentDAO = DAOFactory.getDepartmentInstance();
    @Test
    public void selectAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        departmentList.forEach(department -> System.out.println(department));
    }
    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setDepartmentName("测试院系");
        department.setLogo("https://huangjingli.oss-cn-beijing.aliyuncs.com/logo/75ddc1ab-563a-4043-a776-7e0190b27129.png");
        try {
            int n = departmentDAO.insertDepartment(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteDepartmentById() {
        int id = 2;
        try {
            departmentDAO.deleteDepartmentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
};
