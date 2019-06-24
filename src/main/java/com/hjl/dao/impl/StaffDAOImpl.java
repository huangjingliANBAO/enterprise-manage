package com.hjl.dao.impl;
import com.hjl.dao.StaffDAO;
import com.hjl.entity.Staff;
import com.hjl.entity.StaffVO;
import com.hjl.utils.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StaffDAOImpl implements StaffDAO {
    @Override
    public List<StaffVO> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT t1.*,t2.department_name\n" +
                "FROM t_staff t1\n" +
                "LEFT JOIN t_department t2\n" +
                "ON t1.department_id=t2.`id`";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<StaffVO> staffVOList = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return staffVOList;
    }
    @Override
    public int insertStaff(Staff staff) throws SQLException {
      JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
      Connection connection = jdbcUtil.getConnection();
      String sql = "INSERT INTO  t_staff(staff_id,department_id,staff_work,staff_avatar,staff_date) VALUE (?,?,?,?,?)";
      PreparedStatement pstmt = connection.prepareStatement(sql);
      pstmt.setString(1,staff.getStaffId());
      pstmt.setString(2,staff.getDepartmentId());
      pstmt.setString(3,staff.getStaffWork());
      pstmt.setString(4,staff.getStaffAvatar());
      pstmt.setDate(5, new Date(staff.getStaffDate().getTime()));
      int n = pstmt.executeUpdate();
      pstmt.close();
      connection.close();
      return n;
    }
    @Override
    public int deleteStaff(int id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_staff WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
    @Override
    public int updateStaff(Staff staff) throws SQLException {
       JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
       Connection connection = jdbcUtil.getConnection();
       String sql = "UPDATE  t_staff SET  staff_address = ? WHERE staff_id = ?";
       PreparedStatement pstmt = connection.prepareStatement(sql);
       pstmt.setString(1,staff.getStaffAddress());
       pstmt.setString(2,staff.getStaffId());
       int n = pstmt.executeUpdate();
       pstmt.close();
       connection.close();
       return n;
    }
    private List<StaffVO> convert(ResultSet rs)throws SQLException{
        List<StaffVO> staffVOList = new ArrayList<>();
        while (rs.next()) {
            StaffVO staff = new StaffVO();
            staff.setStaffId(rs.getString("staff_id"));
            staff.setDepartmentId(rs.getString("department_id"));
            staff.setStaffWork(rs.getString("staff_work"));
            staff.setStaffAvatar(rs.getString("staff_avatar"));
            staff.setDepartmentName(rs.getString("department_name"));
            staff.setStaffPhone(rs.getString("staff_phone"));
            staff.setStaffAddress(rs.getString("staff_address"));
            staff.setStaffDate(rs.getDate("staff_date"));
            /**
             * 数据库数据添加到staffVOList集合
             */
            staffVOList.add(staff);
        }
        return staffVOList;
    }
}


