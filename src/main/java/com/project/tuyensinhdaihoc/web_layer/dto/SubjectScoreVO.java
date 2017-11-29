package com.project.tuyensinhdaihoc.web_layer.dto;

import com.project.tuyensinhdaihoc.data_access_layer.model.Subject;

public class SubjectScoreVO {
    private Integer id;
    private String subName;
    private Double subScore;

    public SubjectScoreVO() {
    }

    public SubjectScoreVO(Integer id) {
        this.id = id;
    }

    public SubjectScoreVO(Integer id, String subName, Double subScore) {
        this.id = id;
        this.subName = subName;
        this.subScore = subScore;
    }

    public SubjectScoreVO(Subject sub) {
        setId(sub.getId());
        setSubName(sub.getName());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Double getSubScore() {
        return subScore;
    }

    public void setSubScore(Double subScore) {
        this.subScore = subScore;
    }
}
