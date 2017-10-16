package com.hong.admin.dao.entity.order;

import java.util.Date;

public class PayOrder {
    private Integer id;

    private Integer orderId;

    private String code;

    private String type;

    private String nurseName;

    private String nursePhone;

    private Integer nurseId;

    private Integer brokerId;

    private String brokerName;

    private String brokerPhone;

    private Float fwf;

    private Integer dj;

    private Float khzf;

    private Integer gz;

    private Date payTime;

    private String nurseBankCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName == null ? null : nurseName.trim();
    }

    public String getNursePhone() {
        return nursePhone;
    }

    public void setNursePhone(String nursePhone) {
        this.nursePhone = nursePhone == null ? null : nursePhone.trim();
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName == null ? null : brokerName.trim();
    }

    public String getBrokerPhone() {
        return brokerPhone;
    }

    public void setBrokerPhone(String brokerPhone) {
        this.brokerPhone = brokerPhone == null ? null : brokerPhone.trim();
    }

    public Float getFwf() {
        return fwf;
    }

    public void setFwf(Float fwf) {
        this.fwf = fwf;
    }

    public Integer getDj() {
        return dj;
    }

    public void setDj(Integer dj) {
        this.dj = dj;
    }

    public Float getKhzf() {
        return khzf;
    }

    public void setKhzf(Float khzf) {
        this.khzf = khzf;
    }

    public Integer getGz() {
        return gz;
    }

    public void setGz(Integer gz) {
        this.gz = gz;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getNurseBankCode() {
        return nurseBankCode;
    }

    public void setNurseBankCode(String nurseBankCode) {
        this.nurseBankCode = nurseBankCode == null ? null : nurseBankCode.trim();
    }
}