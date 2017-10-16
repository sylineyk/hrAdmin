package com.hong.admin.dao.entity.nurse;

import java.util.Date;
import java.util.List;

public class Nurse {
    private Integer id;

    private String phoneNumber;

    private String password;

    private Date createTime;

    private String type;

    private Integer age;

    private String zodiac;

    private String birth;

    private Double experience;

    private Integer salary;

    private String card;

    private Integer brokerId;

    private String status;

    private String name;

    private String serviceArea;

    private String imgPath;

    private String locationArea;

    private String idcard;

    private String sex;

    private String xl;

    private String mz;

    private Integer high;

    private Integer weight;

    private String health;

    private String homeAddress;

    private String hy;

    private String yy;

    private String pr;

    private String gz;

    private String sydq;

    private String gspj;

    private String ssgs;

    private String ssjjr;

    private Date htStartDate;

    private Date htEndDate;


    private String khyh;

    private String bankCode;

    private String level;

    private String ywxh;


    private String nurseZdgType;

    private String salaryType;


    private String paramStr;

    private List<Integer> dataIds;


    private String pathRy;
    private String pathCard;
    private String pathLive;

    private String delRy;
    private String delCard;
    private String delLive;

    private String pathHeader;

    private String typeNames;

    private String serviceAreaNames;


    private String htStartDateStr;

    private String htEndDateStr;


    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac == null ? null : zodiac.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea == null ? null : serviceArea.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(String locationArea) {
        this.locationArea = locationArea == null ? null : locationArea.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl == null ? null : xl.trim();
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz == null ? null : mz.trim();
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getHy() {
        return hy;
    }

    public void setHy(String hy) {
        this.hy = hy == null ? null : hy.trim();
    }

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy == null ? null : yy.trim();
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr == null ? null : pr.trim();
    }

    public String getGz() {
        return gz;
    }

    public void setGz(String gz) {
        this.gz = gz == null ? null : gz.trim();
    }

    public String getSydq() {
        return sydq;
    }

    public void setSydq(String sydq) {
        this.sydq = sydq == null ? null : sydq.trim();
    }

    public String getGspj() {
        return gspj;
    }

    public void setGspj(String gspj) {
        this.gspj = gspj == null ? null : gspj.trim();
    }

    public String getSsgs() {
        return ssgs;
    }

    public void setSsgs(String ssgs) {
        this.ssgs = ssgs == null ? null : ssgs.trim();
    }

    public String getSsjjr() {
        return ssjjr;
    }

    public void setSsjjr(String ssjjr) {
        this.ssjjr = ssjjr == null ? null : ssjjr.trim();
    }

    public Date getHtStartDate() {
        return htStartDate;
    }

    public void setHtStartDate(Date htStartDate) {
        this.htStartDate = htStartDate;
    }

    public Date getHtEndDate() {
        return htEndDate;
    }

    public void setHtEndDate(Date htEndDate) {
        this.htEndDate = htEndDate;
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh == null ? null : khyh.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getYwxh() {
        return ywxh;
    }

    public void setYwxh(String ywxh) {
        this.ywxh = ywxh == null ? null : ywxh.trim();
    }

    public String getNurseZdgType() {
        return nurseZdgType;
    }

    public void setNurseZdgType(String nurseZdgType) {
        this.nurseZdgType = nurseZdgType;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public List<Integer> getDataIds() {
        return dataIds;
    }

    public void setDataIds(List<Integer> dataIds) {
        this.dataIds = dataIds;
    }

    public String getPathRy() {
        return pathRy;
    }

    public void setPathRy(String pathRy) {
        this.pathRy = pathRy;
    }

    public String getPathCard() {
        return pathCard;
    }

    public void setPathCard(String pathCard) {
        this.pathCard = pathCard;
    }

    public String getPathLive() {
        return pathLive;
    }

    public void setPathLive(String pathLive) {
        this.pathLive = pathLive;
    }

    public String getDelRy() {
        return delRy;
    }

    public void setDelRy(String delRy) {
        this.delRy = delRy;
    }

    public String getDelCard() {
        return delCard;
    }

    public void setDelCard(String delCard) {
        this.delCard = delCard;
    }

    public String getDelLive() {
        return delLive;
    }

    public void setDelLive(String delLive) {
        this.delLive = delLive;
    }

    public String getPathHeader() {
        return pathHeader;
    }

    public void setPathHeader(String pathHeader) {
        this.pathHeader = pathHeader;
    }

    public String getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(String typeNames) {
        this.typeNames = typeNames;
    }

    public String getServiceAreaNames() {
        return serviceAreaNames;
    }

    public void setServiceAreaNames(String serviceAreaNames) {
        this.serviceAreaNames = serviceAreaNames;
    }

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }

    public String getHtStartDateStr() {
        return htStartDateStr;
    }

    public void setHtStartDateStr(String htStartDateStr) {
        this.htStartDateStr = htStartDateStr;
    }

    public String getHtEndDateStr() {
        return htEndDateStr;
    }

    public void setHtEndDateStr(String htEndDateStr) {
        this.htEndDateStr = htEndDateStr;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}