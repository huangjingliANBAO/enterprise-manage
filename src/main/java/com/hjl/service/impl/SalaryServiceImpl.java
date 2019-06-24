package com.hjl.service.impl;

import com.hjl.dao.SalaryDAO;
import com.hjl.entity.SalaryVO;
import com.hjl.factory.DAOFactory;
import com.hjl.service.SalaryService;

import java.sql.SQLException;
import java.util.List;

public class SalaryServiceImpl implements SalaryService {
    private SalaryDAO salaryDAO = DAOFactory.getSalaryInstance();
    @Override
    public List<SalaryVO> selectAll() {
        List<SalaryVO> salaryVOList = null;
        try {
            salaryVOList = salaryDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaryVOList;
    }
}
