package com.hjl.service.impl;

import com.hjl.entity.Department;
import com.hjl.factory.ServiceFactory;
import com.hjl.service.DepartmentService;
import org.junit.Test;

import java.util.List;

public class DepartmentServiceImplTest {

    private DepartmentService departmentService = ServiceFactory.getDepartmentInstance();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(department -> System.out.println(department));
    }
    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setDepartmentName("测试");
        department.setLogo("https://huangjingli.oss-cn-beijing.aliyuncs.com/logo/75ddc1ab-563a-4043-a776-7e0190b27129.png");
        departmentService.insertDepartment(department);
    }
    @Test
    public void deleteDepartment() {
        int id = 2;
        departmentService.deleteDepartment(id);
    }
}