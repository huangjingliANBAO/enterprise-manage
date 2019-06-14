package com.hjl.entity;

import java.util.Date;

public class AttendanceVO {
    private Integer id;
    private Date time;
    private String staffId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "AttendanceVO{" +
                "id=" + id +
                ", time=" + time +
                ", staffId='" + staffId + '\'' +
                '}';
    }
}
