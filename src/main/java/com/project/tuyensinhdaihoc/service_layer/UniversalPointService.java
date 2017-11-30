package com.project.tuyensinhdaihoc.service_layer;

import com.project.tuyensinhdaihoc.web_layer.dto.UniversalPointVO;

import java.util.List;

public interface UniversalPointService {
    List<UniversalPointVO> findAllUniversalPointVO();

    List<String> findAllLabelBlockName();

    List<UniversalPointVO> findUniversalPointById(Integer id);

    List<UniversalPointVO> findUniversalPointByBlockName(String blockName);
}
