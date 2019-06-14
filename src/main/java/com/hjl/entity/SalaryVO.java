package com.hjl.entity;

public class SalaryVO {
    private Integer id;
    private String staffSalary;
    private String staffId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(String staffSalary) {
        this.staffSalary = staffSalary;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "SalaryVO{" +
                "id=" + id +
                ", staffSalary='" + staffSalary + '\'' +
                ", staffId='" + staffId + '\'' +
                '}';
    }
}
