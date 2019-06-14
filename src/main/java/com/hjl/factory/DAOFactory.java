package com.hjl.factory;

import com.hjl.dao.*;
import com.hjl.dao.impl.*;

public class DAOFactory {
    public static AdminDAO getAdminDAOInstance(){
        return new AdminDAOImpl();
    }
    public static DepartmentDAO getDepartmentInstance(){
        return new DepartmentDAOImpl();
    }
    public static StaffDAO getStaffInstance(){
        return new StaffDAOImpl();
    }
    public static AttendanceDAO getAttendanceInstance(){
        return new AttendanceDAOImpl();
    }
    public static SalaryDAO getSalaryInstance(){
        return new SalaryDAOImpl();
    }
    public static ClientDAO getClientInstance(){
        return new ClientDAOImpl();
    }

}
