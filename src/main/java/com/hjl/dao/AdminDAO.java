package com.hjl.dao;

import com.hjl.entity.Admin;

import java.sql.SQLException;

public interface AdminDAO {
    /**
     * 根据账号查找管理员
     * @param account
     * @return Admin
     * @throws SQLException
     */
    Admin getAdminByAccount(String account)throws SQLException;
}
