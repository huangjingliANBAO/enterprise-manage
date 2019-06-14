package com.hjl.service;

import com.hjl.entity.Staff;
import com.hjl.entity.StaffVO;

import java.util.List;

public interface StaffService {
    List<StaffVO> selectAll();
    int insertStaff(Staff staff);
    int updateStaff(Staff staff);
    int deleteId(int id);

}
