package com.hong.admin.dao.entity.order;

import java.util.Date;

public class MultiOrderAppDetail {
    private Integer id;

    private String serviceTime;

    private Integer address;

    private String name;

    private String phoneNumber;

    private String remarks;

    private String serviceWeek;

    private Date createTime;

    private Integer orderAppointmentId;

    private String houseArea;

    private Integer monthPackage;

    private Float pay;

    private Integer orderId;

    private String cook;

    private Integer monthPay;

    private Integer faceAddress;

    private Date faceTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime == null ? null : serviceTime.trim();
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getServiceWeek() {
        return serviceWeek;
    }

    public void setServiceWeek(String serviceWeek) {
        this.serviceWeek = serviceWeek == null ? null : serviceWeek.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderAppointmentId() {
        return orderAppointmentId;
    }

    public void setOrderAppointmentId(Integer orderAppointmentId) {
        this.orderAppointmentId = orderAppointmentId;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    public Integer getMonthPackage() {
        return monthPackage;
    }

    public void setMonthPackage(Integer monthPackage) {
        this.monthPackage = monthPackage;
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook == null ? null : cook.trim();
    }

    public Integer getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(Integer monthPay) {
        this.monthPay = monthPay;
    }

    public Integer getFaceAddress() {
        return faceAddress;
    }

    public void setFaceAddress(Integer faceAddress) {
        this.faceAddress = faceAddress;
    }

    public Date getFaceTime() {
        return faceTime;
    }

    public void setFaceTime(Date faceTime) {
        this.faceTime = faceTime;
    }
}