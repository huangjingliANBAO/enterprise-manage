package com.hjl.dao.impl;

import com.hjl.dao.AttendanceDAO;
import com.hjl.entity.AttendanceVO;
import com.hjl.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AttendanceDAOImplTest {
  private AttendanceDAO attendanceDAO = DAOFactory.getAttendanceInstance();
    @Test
    public void insertAll() {
        List<AttendanceVO> attendanceVOList = null;
        try {
            attendanceVOList = attendanceDAO.insertAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        attendanceVOList.forEach(attendance -> System.out.println(attendance));
    }
}