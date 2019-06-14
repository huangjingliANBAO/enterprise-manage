package com.hjl.entity;

import java.util.Date;

public class Attendance {
    private Integer id;
    private Date time;

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

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
