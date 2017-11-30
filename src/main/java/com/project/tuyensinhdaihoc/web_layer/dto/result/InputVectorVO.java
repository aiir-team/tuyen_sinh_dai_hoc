package com.project.tuyensinhdaihoc.web_layer.dto.result;

public class InputVectorVO {

    private Integer amountStudent;
    private Integer passScore;
    private Integer univRank;
    private Double prob;
    private Double cStar;

    public InputVectorVO() {
    }

    public InputVectorVO(Integer amountStudent, Integer passScore, Integer univRank, Double prob, Double cStar) {
        this.amountStudent = amountStudent;
        this.passScore = passScore;
        this.univRank = univRank;
        this.prob = prob;
        this.cStar = cStar;
    }

    public Integer getAmountStudent() {
        return amountStudent;
    }

    public void setAmountStudent(Integer amountStudent) {
        this.amountStudent = amountStudent;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getUnivRank() {
        return univRank;
    }

    public void setUnivRank(Integer univRank) {
        this.univRank = univRank;
    }

    public Double getProb() {
        return prob;
    }

    public void setProb(Double prob) {
        this.prob = prob;
    }

    public Double getcStar() {
        return cStar;
    }

    public void setcStar(Double cStar) {
        this.cStar = cStar;
    }
}
