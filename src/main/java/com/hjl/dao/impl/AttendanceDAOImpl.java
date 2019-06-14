package com.hjl.dao.impl;

import com.hjl.dao.AttendanceDAO;
import com.hjl.dao.StaffDAO;
import com.hjl.entity.Attendance;
import com.hjl.entity.AttendanceVO;
import com.hjl.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {
    @Override
    public List<AttendanceVO> insertAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.staff_id\n" +
                "FROM t_attendance t1\n" +
                "LEFT JOIN t_staff t2\n" +
                "ON t1.`id`=t2.`id`";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<AttendanceVO> attendanceVOList = new ArrayList<>();
        while (rs.next()){
            AttendanceVO attendance = new AttendanceVO();
            attendance.setId(rs.getInt("id"));
            attendance.setTime(rs.getTime("time"));
            attendance.setStaffId(rs.getString("staff_id"));
            attendanceVOList.add(attendance);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return attendanceVOList;
    }
}
