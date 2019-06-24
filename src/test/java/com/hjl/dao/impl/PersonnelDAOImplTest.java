package com.hjl.dao.impl;

import com.hjl.dao.PersonnelDAO;
import com.hjl.entity.Personnel;
import com.hjl.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ListResourceBundle;

import static org.junit.Assert.*;

public class PersonnelDAOImplTest {
private PersonnelDAO personnelDAO = DAOFactory.getPersonnelInstance();
    @Test
    public void getPersonnelByAccount() {
        try {
            Personnel personnel = personnelDAO.getPersonnelByAccount("22");
            if (personnel != null){
                System.out.println(personnel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}