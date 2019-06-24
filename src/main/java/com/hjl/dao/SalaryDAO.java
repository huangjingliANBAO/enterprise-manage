package com.hjl.dao;

import com.hjl.entity.SalaryVO;

import java.sql.SQLException;
import java.util.List;

public interface SalaryDAO {
    /**
     * 查看员工薪水
     * @return  List
     * @throws SQLException
     */
    List<SalaryVO> selectAll()throws SQLException;
}
