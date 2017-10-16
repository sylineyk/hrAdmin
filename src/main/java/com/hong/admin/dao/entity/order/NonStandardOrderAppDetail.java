package com.hong.admin.dao.entity.order;

import java.util.Date;

public class NonStandardOrderAppDetail {
    private Integer id;

    private Date orderCreateDate;

    private Date serviceStartDate;

    private Date serviceEndDate;

    private Integer address;

    private Float amount;

    private Integer orderId;

    private String name;

    private String phoneNumber;

    private String remarks;

    private Integer orderAppointmentId;

    private String faceMarks;

    private String houseArea;

    private Integer orderCountPay;

    private Integer agentPay;

    private Integer bzjPay;

    private Integer faceAddress;

    private Date faceTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getOrderAppointmentId() {
        return orderAppointmentId;
    }

    public void setOrderAppointmentId(Integer orderAppointmentId) {
        this.orderAppointmentId = orderAppointmentId;
    }

    public String getFaceMarks() {
        return faceMarks;
    }

    public void setFaceMarks(String faceMarks) {
        this.faceMarks = faceMarks == null ? null : faceMarks.trim();
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    public Integer getOrderCountPay() {
        return orderCountPay;
    }

    public void setOrderCountPay(Integer orderCountPay) {
        this.orderCountPay = orderCountPay;
    }

    public Integer getAgentPay() {
        return agentPay;
    }

    public void setAgentPay(Integer agentPay) {
        this.agentPay = agentPay;
    }

    public Integer getBzjPay() {
        return bzjPay;
    }

    public void setBzjPay(Integer bzjPay) {
        this.bzjPay = bzjPay;
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