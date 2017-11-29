package com.project.tuyensinhdaihoc.web_layer.dto;

import java.sql.Date;

public class UniversityDetailVO {
    private Integer id;
    private Integer order;
    private String univCode;
    private String univName;
    private String univLevel;
    private String branName;
    private String branCode;
    private String combCode;
    private Integer amountStudent;
    private String typeAdmission;
    private Integer totalScore;
    private Date receiveTime;
    private Date deadlineTime;
    private String geographic;
    private Integer univRank;

    public UniversityDetailVO() {
    }

    public UniversityDetailVO(Integer id, Integer order, String univCode, String univName, String univLevel, String branName, String branCode, String combCode, Integer amountStudent, String typeAdmission, Integer totalScore, Date receiveTime, Date deadlineTime, String geographic, Integer univRank) {
        this.id = id;
        this.order = order;
        this.univCode = univCode;
        this.univName = univName;
        this.univLevel = univLevel;
        this.branName = branName;
        this.branCode = branCode;
        this.combCode = combCode;
        this.amountStudent = amountStudent;
        this.typeAdmission = typeAdmission;
        this.totalScore = totalScore;
        this.receiveTime = receiveTime;
        this.deadlineTime = deadlineTime;
        this.geographic = geographic;
        this.univRank = univRank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getUnivCode() {
        return univCode;
    }

    public void setUnivCode(String univCode) {
        this.univCode = univCode;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getUnivLevel() {
        return univLevel;
    }

    public void setUnivLevel(String univLevel) {
        this.univLevel = univLevel;
    }

    public String getBranName() {
        return branName;
    }

    public void setBranName(String branName) {
        this.branName = branName;
    }

    public String getBranCode() {
        return branCode;
    }

    public void setBranCode(String branCode) {
        this.branCode = branCode;
    }

    public String getCombCode() {
        return combCode;
    }

    public void setCombCode(String combCode) {
        this.combCode = combCode;
    }

    public Integer getAmountStudent() {
        return amountStudent;
    }

    public void setAmountStudent(Integer amountStudent) {
        this.amountStudent = amountStudent;
    }

    public String getTypeAdmission() {
        return typeAdmission;
    }

    public void setTypeAdmission(String typeAdmission) {
        this.typeAdmission = typeAdmission;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public String getGeographic() {
        return geographic;
    }

    public void setGeographic(String geographic) {
        this.geographic = geographic;
    }

    public Integer getUnivRank() {
        return univRank;
    }

    public void setUnivRank(Integer univRank) {
        this.univRank = univRank;
    }
}
