package com.hong.admin.query.entity;

import java.util.Date;

/**
 * Created by syline on 2017/7/22.
 */
public class QueryEntity {
    private Date starDate;
    private Date endDate;

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
