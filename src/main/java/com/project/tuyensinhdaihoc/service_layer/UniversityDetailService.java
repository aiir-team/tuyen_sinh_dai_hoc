package com.project.tuyensinhdaihoc.service_layer;

import com.project.tuyensinhdaihoc.web_layer.dto.UnivNameVO;
import com.project.tuyensinhdaihoc.web_layer.dto.UniversityDetailVO;
import com.project.tuyensinhdaihoc.web_layer.dto.UserInputVO;

import java.util.List;

public interface UniversityDetailService {

    List<String> findAllDistinctBranch();

    List<String> findAllSubject();

    List<String> findAllUnivGeographic();

    List<String> findAllUnivName();

    List<UnivNameVO> findAllUnivNameVO();

    List<UniversityDetailVO> HTGQDBasedOn(UserInputVO userInputVO);

    List<UniversityDetailVO> findAllUniversityDetailVO();

    List<UniversityDetailVO> findAllUniversityDetailVOByUnivCode(String univCode);

}
