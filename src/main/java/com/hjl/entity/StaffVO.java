package com.hjl.entity;

import java.util.Date;

public class StaffVO {
    private Integer id;
    private String staffId;
    private String departmentId;
    private String staffWork;
    private String staffAvatar;
    private Date staffDate;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getStaffWork() {
        return staffWork;
    }

    public void setStaffWork(String staffWork) {
        this.staffWork = staffWork;
    }

    public String getStaffAvatar() {
        return staffAvatar;
    }

    public void setStaffAvatar(String staffAvatar) {
        this.staffAvatar = staffAvatar;
    }

    public Date getStaffDate() {
        return staffDate;
    }

    public void setStaffDate(Date staffDate) {
        this.staffDate = staffDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "StaffVO{" +
                "id=" + id +
                ", staffId='" + staffId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", staffWork='" + staffWork + '\'' +
                ", staffAvatar='" + staffAvatar + '\'' +
                ", staffDate=" + staffDate +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
