package com.hjl.dao.impl;

import com.hjl.dao.SalaryDAO;
import com.hjl.entity.AttendanceVO;
import com.hjl.entity.SalaryVO;
import com.hjl.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public List<SalaryVO> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.staff_id\n" +
                "FROM t_salary t1\n" +
                "LEFT JOIN t_staff t2\n" +
                "ON t1.`id`=t2.`id`";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<SalaryVO> salaryVOList = new ArrayList<>();
        while (rs.next()){
           SalaryVO salaryVO = new SalaryVO();
            salaryVO.setId(rs.getInt("id"));
            salaryVO.setStaffSalary(rs.getString("staff_salary"));
            salaryVO.setStaffId(rs.getString("staff_id"));
            salaryVOList.add(salaryVO);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return salaryVOList;
    }

}
