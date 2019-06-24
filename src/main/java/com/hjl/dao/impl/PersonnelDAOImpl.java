package com.hjl.dao.impl;

import com.hjl.dao.PersonnelDAO;
import com.hjl.entity.Personnel;
import com.hjl.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelDAOImpl implements PersonnelDAO {
    @Override
    public Personnel getPersonnelByAccount(String account) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_personnel where account = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,account);
        ResultSet rs = pstmt.executeQuery();
        Personnel personnel = null;
        while (rs.next()){
            int id = rs.getInt("id");
            String personnelAccount = rs.getString("account");
            String password = rs.getString("password");
            String personnelName = rs.getString("personnel_name");
            personnel = new Personnel();
            personnel.setId(id);
            personnel.setAccount(personnelAccount);
            personnel.setPassword(password);
            personnel.setPersonnelName(personnelName);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return personnel;
    }
}
