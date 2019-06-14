package com.hjl.entity;

public class Salary {
    private Integer id;
    private String staffSalary;

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

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", staffSalary='" + staffSalary + '\'' +
                '}';
    }
}
