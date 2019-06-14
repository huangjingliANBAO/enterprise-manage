package com.hjl.service.impl;

import com.hjl.factory.ServiceFactory;
import com.hjl.service.AdminService;
import com.hjl.utils.ResultEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceImplTest {
private AdminService adminService = ServiceFactory.getAdminServiceInstance();
    @Test
    public void adminLogin() {
        ResultEntity resultEntity =
                adminService.adminLogin("11","123");
        System.out.println(resultEntity);
    }
}