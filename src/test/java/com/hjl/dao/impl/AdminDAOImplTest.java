package com.hjl.dao.impl;

import com.hjl.dao.AdminDAO;
import com.hjl.entity.Admin;
import com.hjl.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

public class AdminDAOImplTest {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Test
    public void getAdminByAccount() {
        try {
            Admin admin = adminDAO.getAdminByAccount("11");
            if (admin != null) {
                System.out.println(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
