package com.hjl.service.impl;

import com.hjl.entity.Staff;
import com.hjl.entity.StaffVO;
import com.hjl.factory.ServiceFactory;
import com.hjl.service.StaffService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StaffServiceImplTest {
    private StaffService staffService = ServiceFactory.getStaffInstance();

    @Test
    public void selectAll() {
        List<StaffVO> staffVOList = staffService.selectAll();
        staffVOList.forEach(staffVO -> System.out.println(staffVO));
    }

    @Test
    public void insertStaff() {
        Staff staff = new Staff();
        staff.setStaffId("测试测试");
        staff.setDepartmentId("1");
        staff.setStaffWork("UI美工");
        staff.setStaffAvatar("https://huangjingli.oss-cn-beijing.aliyuncs.com/logo/%E8%A9%B9%E5%A7%86%E6%96%AF.jpg");
        staff.setStaffDate(new Date());
        staffService.insertStaff(staff);
    }

    @Test
    public void updateStaff() {
        Staff staff = new Staff();
        staff.setStaffId("GG111");
        staff.setStaffAddress("成都");
        staffService.updateStaff(staff);
    }

    @Test
    public void deleteId() {
       int id = 2;
       staffService.deleteId(id);
    }
}