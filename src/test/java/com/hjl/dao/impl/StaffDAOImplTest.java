package com.hjl.dao.impl;

import com.hjl.dao.StaffDAO;
import com.hjl.entity.Staff;
import com.hjl.entity.StaffVO;
import com.hjl.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StaffDAOImplTest {
    private StaffDAO staffDAO = DAOFactory.getStaffInstance();
    @Test
    public void selectAll() {
        List<StaffVO> staffVOList = null;
        try {
            staffVOList = staffDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        staffVOList.forEach(staff -> System.out.println(staff));
    }
    @Test
    public void insertStaff() throws SQLException{
        Staff staff = new Staff();
        staff.setStaffId("GG114");
        staff.setDepartmentId("1");
        staff.setStaffAvatar("https://huangjingli.oss-cn-beijing.aliyuncs.com/logo/%E8%A9%B9%E5%A7%86%E6%96%AF.jpg");
        staff.setStaffWork("UI美工");
        staff.setStaffDate(new Date());
        int n = staffDAO.insertStaff(staff);
        assertEquals(1,n);
    }
    @Test
    public void deleteStaff()throws SQLException {
        int id = 1;
        int n = staffDAO.deleteStaff(id);
    }

    @Test
    public void updateStaff()throws SQLException {
        Staff staff = new Staff();
        staff.setStaffId("GG111");
        staff.setStaffAddress("西安");

        int n = staffDAO.updateStaff(staff);
    }
}