package com.project.tuyensinhdaihoc.web_layer.dto;

public class AdvisoryVO {
    private Integer id;
    private Integer mainGroup;
    private Integer examBlock;
    private Integer levelUniversity;
    private Integer priority;
    private Float sumScore;
    private Integer typeUniversity;
    private Integer city;

    public AdvisoryVO() {
    }

    public AdvisoryVO(Integer id, Integer mainGroup, Integer examBlock, Integer levelUniversity, Integer priority, Float sumScore, Integer typeUniversity, Integer city) {
        this.id = id;
        this.mainGroup = mainGroup;
        this.examBlock = examBlock;
        this.levelUniversity = levelUniversity;
        this.priority = priority;
        this.sumScore = sumScore;
        this.typeUniversity = typeUniversity;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainGroup() {
        return mainGroup;
    }

    public void setMainGroup(Integer mainGroup) {
        this.mainGroup = mainGroup;
    }

    public Integer getExamBlock() {
        return examBlock;
    }

    public void setExamBlock(Integer examBlock) {
        this.examBlock = examBlock;
    }

    public Integer getLevelUniversity() {
        return levelUniversity;
    }

    public void setLevelUniversity(Integer levelUniversity) {
        this.levelUniversity = levelUniversity;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Float getSumScore() {
        return sumScore;
    }

    public void setSumScore(Float sumScore) {
        this.sumScore = sumScore;
    }

    public Integer getTypeUniversity() {
        return typeUniversity;
    }

    public void setTypeUniversity(Integer typeUniversity) {
        this.typeUniversity = typeUniversity;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }
}

