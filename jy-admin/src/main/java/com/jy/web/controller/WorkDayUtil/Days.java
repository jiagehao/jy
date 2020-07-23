package com.jy.web.controller.WorkDayUtil;

import java.util.Date;

/**
 * Created by 彭嘉颖 on 2018/6/24.
 */
public class Days {
    String uuid;
    String name;
    Date date;

    public Days(String uuid, String name, Date date) {
        this.uuid = uuid;
        this.name = name;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDates(Date date) {
        this.date = date;
    }
}
