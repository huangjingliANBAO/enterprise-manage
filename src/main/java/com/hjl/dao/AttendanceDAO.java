package com.hjl.dao;

import com.hjl.entity.AttendanceVO;

import java.sql.SQLException;
import java.util.List;

public interface AttendanceDAO {
    /**
     * 查看员工考勤时间
     * @return List
     * @throws SQLException
     */
    List<AttendanceVO> insertAll()throws SQLException;
}
