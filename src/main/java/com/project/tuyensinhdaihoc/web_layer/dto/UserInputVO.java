package com.project.tuyensinhdaihoc.web_layer.dto;

import java.util.List;

public class UserInputVO {
    private Integer id;

    private String branchName;
    private Integer wBranch;

    private String univLevel;
    private List<SubjectScoreVO> subjectScoreVOList;
    private Double regionScore;     /* 0, 0.5, 1.0, 1.5 */
    private Double priorityScore;   /* 0, 1.0, 2.0 */

    private Double totalScore;
    private Integer wTotalScore;

    private String univRegion;
    private Integer wRegion;

    private Integer univRank;
    private Integer wRank;

    private List<WeightVO> weightVOList;         // amount_student, score, rank, main_subject

    public UserInputVO() {
        this.wBranch = 7;
        this.wTotalScore = 9;
        this.wRegion = 5;
        this.wRank = 3;
    }

    public UserInputVO(Integer id, String branchName, Integer wBranch, String univLevel, List<SubjectScoreVO> subjectScoreVOList, Double regionScore, Double priorityScore, Double totalScore, Integer wTotalScore, String univRegion, Integer wRegion, Integer univRank, Integer wRank) {
        this.id = id;
        this.branchName = branchName;
        this.wBranch = wBranch;
        this.univLevel = univLevel;
        this.subjectScoreVOList = subjectScoreVOList;
        this.regionScore = regionScore;
        this.priorityScore = priorityScore;
        this.totalScore = totalScore;
        this.wTotalScore = wTotalScore;
        this.univRegion = univRegion;
        this.wRegion = wRegion;
        this.univRank = univRank;
        this.wRank = wRank;
    }

    public UserInputVO(Integer id, String branchName, Integer wBranch, String univLevel, List<SubjectScoreVO> subjectScoreVOList, Double regionScore, Double priorityScore, Double totalScore, Integer wTotalScore, String univRegion, Integer wRegion, Integer univRank, Integer wRank, List<WeightVO> weightVOList) {
        this.id = id;
        this.branchName = branchName;
        this.wBranch = wBranch;
        this.univLevel = univLevel;
        this.subjectScoreVOList = subjectScoreVOList;
        this.regionScore = regionScore;
        this.priorityScore = priorityScore;
        this.totalScore = totalScore;
        this.wTotalScore = wTotalScore;
        this.univRegion = univRegion;
        this.wRegion = wRegion;
        this.univRank = univRank;
        this.wRank = wRank;
        this.weightVOList = weightVOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getwBranch() {
        return wBranch;
    }

    public void setwBranch(Integer wBranch) {
        this.wBranch = wBranch;
    }

    public String getUnivLevel() {
        return univLevel;
    }

    public void setUnivLevel(String univLevel) {
        this.univLevel = univLevel;
    }

    public List<SubjectScoreVO> getSubjectScoreVOList() {
        return subjectScoreVOList;
    }

    public void setSubjectScoreVOList(List<SubjectScoreVO> subjectScoreVOList) {
        this.subjectScoreVOList = subjectScoreVOList;
    }

    public Double getRegionScore() {
        return regionScore;
    }

    public void setRegionScore(Double regionScore) {
        this.regionScore = regionScore;
    }

    public Double getPriorityScore() {
        return priorityScore;
    }

    public void setPriorityScore(Double priorityScore) {
        this.priorityScore = priorityScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getwTotalScore() {
        return wTotalScore;
    }

    public void setwTotalScore(Integer wTotalScore) {
        this.wTotalScore = wTotalScore;
    }

    public String getUnivRegion() {
        return univRegion;
    }

    public void setUnivRegion(String univRegion) {
        this.univRegion = univRegion;
    }

    public Integer getwRegion() {
        return wRegion;
    }

    public void setwRegion(Integer wRegion) {
        this.wRegion = wRegion;
    }

    public Integer getUnivRank() {
        return univRank;
    }

    public void setUnivRank(Integer univRank) {
        this.univRank = univRank;
    }

    public Integer getwRank() {
        return wRank;
    }

    public void setwRank(Integer wRank) {
        this.wRank = wRank;
    }


    public List<WeightVO> getWeightVOList() {
        return weightVOList;
    }

    public void setWeightVOList(List<WeightVO> weightVOList) {
        this.weightVOList = weightVOList;
    }
}
