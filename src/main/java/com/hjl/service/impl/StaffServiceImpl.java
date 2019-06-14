package com.hjl.service.impl;

import com.hjl.dao.StaffDAO;
import com.hjl.entity.Staff;
import com.hjl.entity.StaffVO;
import com.hjl.factory.DAOFactory;
import com.hjl.service.StaffService;

import java.sql.SQLException;
import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffDAO staffDAO = DAOFactory.getStaffInstance();

    @Override
    public List<StaffVO> selectAll() {
        List<StaffVO> staffVOList = null;
        try {
            staffVOList = staffDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffVOList;
    }

    @Override
    public int insertStaff(Staff staff) {
        int n = 0;
        try {
            n = staffDAO.insertStaff(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int updateStaff(Staff staff) {
        int n = 0;
        try {
            n = staffDAO.updateStaff(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteId(int id) {
        int n = 0;
        try {
            n = staffDAO.deleteStaff(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
