package com.project.tuyensinhdaihoc.data_access_layer.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "university_detail", schema = "tsdh", catalog = "")
public class UniversityDetail {
    private int id;
    private String univCode;
    private String univName;
    private String univLevel;
    private String branchName;
    private String branchCode;
    private String combinationCode;
    private int amountStudent;
    private String typeAdmission;
    private double totalScore;
    private Timestamp receiveTime;
    private Timestamp deadlineTime;
    private String geographic;
    private int univRank;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "univ_code", nullable = false, length = 64)
    public String getUnivCode() {
        return univCode;
    }

    public void setUnivCode(String univCode) {
        this.univCode = univCode;
    }

    @Basic
    @Column(name = "univ_name", nullable = false, length = 256)
    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    @Basic
    @Column(name = "univ_level", nullable = false, length = 64)
    public String getUnivLevel() {
        return univLevel;
    }

    public void setUnivLevel(String univLevel) {
        this.univLevel = univLevel;
    }

    @Basic
    @Column(name = "branch_name", nullable = false, length = 256)
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Basic
    @Column(name = "branch_code", nullable = false, length = 64)
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Basic
    @Column(name = "combination_code", nullable = false, length = 256)
    public String getCombinationCode() {
        return combinationCode;
    }

    public void setCombinationCode(String combinationCode) {
        this.combinationCode = combinationCode;
    }

    @Basic
    @Column(name = "amount_student", nullable = false)
    public int getAmountStudent() {
        return amountStudent;
    }

    public void setAmountStudent(int amountStudent) {
        this.amountStudent = amountStudent;
    }

    @Basic
    @Column(name = "type_admission", nullable = false, length = 64)
    public String getTypeAdmission() {
        return typeAdmission;
    }

    public void setTypeAdmission(String typeAdmission) {
        this.typeAdmission = typeAdmission;
    }

    @Basic
    @Column(name = "total_score", nullable = false, precision = 2)
    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    @Basic
    @Column(name = "receive_time", nullable = false)
    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Basic
    @Column(name = "deadline_time", nullable = false)
    public Timestamp getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Timestamp deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    @Basic
    @Column(name = "geographic", nullable = false, length = 256)
    public String getGeographic() {
        return geographic;
    }

    public void setGeographic(String geographic) {
        this.geographic = geographic;
    }

    @Basic
    @Column(name = "univ_rank", nullable = false)
    public int getUnivRank() {
        return univRank;
    }

    public void setUnivRank(int univRank) {
        this.univRank = univRank;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniversityDetail that = (UniversityDetail) o;

        if (id != that.id) return false;
        if (amountStudent != that.amountStudent) return false;
        if (Double.compare(that.totalScore, totalScore) != 0) return false;
        if (univRank != that.univRank) return false;
        if (univCode != null ? !univCode.equals(that.univCode) : that.univCode != null) return false;
        if (univName != null ? !univName.equals(that.univName) : that.univName != null) return false;
        if (univLevel != null ? !univLevel.equals(that.univLevel) : that.univLevel != null) return false;
        if (branchName != null ? !branchName.equals(that.branchName) : that.branchName != null) return false;
        if (branchCode != null ? !branchCode.equals(that.branchCode) : that.branchCode != null) return false;
        if (combinationCode != null ? !combinationCode.equals(that.combinationCode) : that.combinationCode != null)
            return false;
        if (typeAdmission != null ? !typeAdmission.equals(that.typeAdmission) : that.typeAdmission != null)
            return false;
        if (receiveTime != null ? !receiveTime.equals(that.receiveTime) : that.receiveTime != null) return false;
        if (deadlineTime != null ? !deadlineTime.equals(that.deadlineTime) : that.deadlineTime != null) return false;
        if (geographic != null ? !geographic.equals(that.geographic) : that.geographic != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (univCode != null ? univCode.hashCode() : 0);
        result = 31 * result + (univName != null ? univName.hashCode() : 0);
        result = 31 * result + (univLevel != null ? univLevel.hashCode() : 0);
        result = 31 * result + (branchName != null ? branchName.hashCode() : 0);
        result = 31 * result + (branchCode != null ? branchCode.hashCode() : 0);
        result = 31 * result + (combinationCode != null ? combinationCode.hashCode() : 0);
        result = 31 * result + amountStudent;
        result = 31 * result + (typeAdmission != null ? typeAdmission.hashCode() : 0);
        temp = Double.doubleToLongBits(totalScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (receiveTime != null ? receiveTime.hashCode() : 0);
        result = 31 * result + (deadlineTime != null ? deadlineTime.hashCode() : 0);
        result = 31 * result + (geographic != null ? geographic.hashCode() : 0);
        result = 31 * result + univRank;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
