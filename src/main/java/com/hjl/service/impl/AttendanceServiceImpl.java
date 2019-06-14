package com.hjl.service.impl;

import com.hjl.dao.AttendanceDAO;
import com.hjl.entity.AttendanceVO;
import com.hjl.factory.DAOFactory;
import com.hjl.service.AttendanceService;

import java.sql.SQLException;
import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceInstance();
    @Override
    public List<AttendanceVO> insertAll() {
        List<AttendanceVO> attendanceVOList = null;
        try {
            attendanceVOList = attendanceDAO.insertAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceVOList;
    }
}
