package com.hjl.service.impl;

import com.hjl.entity.AttendanceVO;
import com.hjl.factory.ServiceFactory;
import com.hjl.service.AttendanceService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AttendanceServiceImplTest {
private AttendanceService attendanceService = ServiceFactory.getAttendanceInstance();
    @Test
    public void insertAll() {
        List<AttendanceVO> attendanceVOList = attendanceService.insertAll();
        attendanceVOList.forEach(attendance -> System.out.println(attendance));
    }
}