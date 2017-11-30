package com.project.tuyensinhdaihoc.web_layer.dto.result;

import com.project.tuyensinhdaihoc.data_access_layer.model.UniversityDetail;

public class UniversityResultVO {
    private UniversityDetail universityDetail;
    private InputVectorVO inputVectorVO;
    private Double cStar;

    public UniversityResultVO() {
    }
    public UniversityResultVO(UniversityDetail universityDetail, InputVectorVO inputVectorVO, Double cStar) {
        this.universityDetail = universityDetail;
        this.inputVectorVO = inputVectorVO;
        this.cStar = cStar;
    }

    public UniversityResultVO(UniversityDetail universityDetail, InputVectorVO inputVectorVO) {
        this.universityDetail = universityDetail;
        this.inputVectorVO = inputVectorVO;
    }

    public UniversityDetail getUniversityDetail() {
        return universityDetail;
    }

    public void setUniversityDetail(UniversityDetail universityDetail) {
        this.universityDetail = universityDetail;
    }

    public InputVectorVO getInputVectorVO() {
        return inputVectorVO;
    }

    public void setInputVectorVO(InputVectorVO inputVectorVO) {
        this.inputVectorVO = inputVectorVO;
    }

    public Double getcStar() {
        return cStar;
    }

    public void setcStar(Double cStar) {
        this.cStar = cStar;
    }
}
