package com.hjl.factory;

import com.hjl.service.*;
import com.hjl.service.impl.*;

public class ServiceFactory {
    public static AdminService getAdminServiceInstance(){
        return new AdminServiceImpl();
    }
    public static DepartmentService getDepartmentInstance(){
        return new DepartmentServiceImpl();
    }
    public static StaffService getStaffInstance(){
        return new StaffServiceImpl();
    }
  public static SalaryService getSalaryInstance(){
        return new SalaryServiceImpl();
  }
  public static AttendanceService getAttendanceInstance(){
        return new AttendanceServiceImpl();
  }
}
