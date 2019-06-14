package com.hjl.dao;

import com.hjl.entity.Staff;
import com.hjl.entity.StaffVO;

import java.sql.SQLException;
import java.util.List;

public interface StaffDAO {
    /**
     * 查询所有员工信息
     * @return List
     * @throws SQLException
     */
    List<StaffVO> selectAll() throws SQLException;

    /**
     * 新增员工
     * @param staff
     * @return int
     * @throws SQLException
     */
    int insertStaff(Staff staff)throws SQLException;

    /**
     * 根据id删除员工
     * @param id
     * @return int
     * @throws SQLException
     */
    int deleteStaff(int id) throws SQLException;

    /**
     *  更新员工信息
     * @param staff
     * @return int
     * @throws SQLException
     */
     int updateStaff(Staff staff)throws  SQLException;


}
