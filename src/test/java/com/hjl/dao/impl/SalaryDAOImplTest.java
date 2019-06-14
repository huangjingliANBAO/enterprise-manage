package com.hjl.dao.impl;

import com.hjl.dao.SalaryDAO;
import com.hjl.entity.SalaryVO;
import com.hjl.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SalaryDAOImplTest {
private SalaryDAO salaryDAO = DAOFactory.getSalaryInstance();
    @Test
    public void insertAll() {
        List<SalaryVO> salaryVOList = null;
        try {
            salaryVOList = salaryDAO.insertAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        salaryVOList.forEach(salary -> System.out.println(salary));
    }
}