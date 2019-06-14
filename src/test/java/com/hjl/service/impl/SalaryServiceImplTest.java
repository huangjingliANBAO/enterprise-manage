package com.hjl.service.impl;

import com.hjl.entity.SalaryVO;
import com.hjl.factory.ServiceFactory;
import com.hjl.service.SalaryService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SalaryServiceImplTest {
private SalaryService salaryService = ServiceFactory.getSalaryInstance();
    @Test
    public void insertAll() {
        List<SalaryVO> salaryVOList = salaryService.insertAll();
        salaryVOList.forEach(salary -> System.out.println(salary));
    }
}