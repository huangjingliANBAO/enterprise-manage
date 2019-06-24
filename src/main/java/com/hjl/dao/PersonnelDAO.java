package com.hjl.dao;

import com.hjl.entity.Personnel;

import java.sql.SQLException;

public interface PersonnelDAO {
    /**
     * 根据员工账户登录
     * @param account
     * @return Personnel
     * @throws SQLException
     */
    Personnel getPersonnelByAccount(String account)throws SQLException;
}
