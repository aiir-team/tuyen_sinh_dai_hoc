package com.project.tuyensinhdaihoc.web_layer.dto;

import com.project.tuyensinhdaihoc.data_access_layer.model.Combination;
import com.project.tuyensinhdaihoc.helper_layer.utils.Calculate;

public class CombinationVO {
    private Integer id;
    private String code;
    private String subName1;
    private String subName2;
    private String subName3;
    private Double totalScore;

    public CombinationVO() {
        this.setCode("000");
    }

    public CombinationVO(Integer id, String code, String subName1, String subName2, String subName3, Double totalScore) {
        this.id = id;
        this.code = code;
        this.subName1 = subName1;
        this.subName2 = subName2;
        this.subName3 = subName3;
        this.totalScore = totalScore;
    }

    public CombinationVO(Combination combination, SubjectScoreVO ss01, SubjectScoreVO ss02, SubjectScoreVO ss03, Double pScore, Double rScore) {
        setId(combination.getId());
        setCode(combination.getCode());
        setSubName1(ss01.getSubName());
        setSubName2(ss02.getSubName());
        setSubName3(ss03.getSubName());
        setTotalScore(ss01.getSubScore(), ss02.getSubScore(), ss03.getSubScore(), pScore, rScore);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubName1() {
        return subName1;
    }

    public void setSubName1(String subName1) {
        this.subName1 = subName1;
    }

    public String getSubName2() {
        return subName2;
    }

    public void setSubName2(String subName2) {
        this.subName2 = subName2;
    }

    public String getSubName3() {
        return subName3;
    }

    public void setSubName3(String subName3) {
        this.subName3 = subName3;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double s1, Double s2, Double s3, Double pScore, Double rScore) {
        Double d = (s1*2 + s2 + s3) * 3 / 4 + pScore + rScore;
        this.totalScore = Calculate.round(d);
    }
}
