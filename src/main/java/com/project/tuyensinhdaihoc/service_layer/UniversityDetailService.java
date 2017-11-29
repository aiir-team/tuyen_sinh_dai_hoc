package com.project.tuyensinhdaihoc.service_layer;

import com.project.tuyensinhdaihoc.data_access_layer.model.Subject;
import com.project.tuyensinhdaihoc.data_access_layer.model.UniversityDetail;
import com.project.tuyensinhdaihoc.web_layer.dto.UniversityDetailVO;
import com.project.tuyensinhdaihoc.web_layer.dto.UserInputVO;

import java.util.List;

public interface UniversityDetailService {

    List<String> findAllDistinctBranch();

    List<String> findAllSubject();

    List<String> findAllUnivGeographic();

    List<UniversityDetailVO> HTGQDBasedOn(UserInputVO userInputVO);
}
