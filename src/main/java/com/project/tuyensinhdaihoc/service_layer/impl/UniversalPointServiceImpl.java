package com.project.tuyensinhdaihoc.service_layer.impl;

import com.project.tuyensinhdaihoc.data_access_layer.model.UniversalPoint;
import com.project.tuyensinhdaihoc.data_access_layer.repository.UniversalPointRepo;
import com.project.tuyensinhdaihoc.service_layer.UniversalPointService;
import com.project.tuyensinhdaihoc.web_layer.dto.BlockNamePointVO;
import com.project.tuyensinhdaihoc.web_layer.dto.UniversalPointVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversalPointServiceImpl implements UniversalPointService {

    private final UniversalPointRepo universalPointRepo;

    @Autowired
    public UniversalPointServiceImpl(UniversalPointRepo universalPointRepo) {
        this.universalPointRepo = universalPointRepo;
    }

    @Override
    public List<UniversalPointVO> findAllUniversalPointVO() {
        List<UniversalPointVO> universalPointVOList = new ArrayList<>();
        List<UniversalPoint> universalPointList = universalPointRepo.findAll();
        for(UniversalPoint up: universalPointList) {
            universalPointVOList.add(new UniversalPointVO(up));
        }
        return universalPointVOList;
    }

    @Override
    public List<String> findAllLabelBlockName() {
        return universalPointRepo.findAllBlockName();
    }

    @Override
    public List<UniversalPointVO> findUniversalPointById(Integer id) {
        List<UniversalPointVO> universalPointVOList = new ArrayList<>();
        List<UniversalPoint> universalPointList = universalPointRepo.findById(id);
        for(UniversalPoint up: universalPointList) {
            universalPointVOList.add(new UniversalPointVO(up));
        }
        return universalPointVOList;
    }

    @Override
    public List<UniversalPointVO> findUniversalPointByBlockName(String blockName) {
        List<UniversalPointVO> universalPointVOList = new ArrayList<>();
        List<UniversalPoint> universalPointList = universalPointRepo.findByBlockName(blockName);
        for(UniversalPoint up: universalPointList) {
            universalPointVOList.add(new UniversalPointVO(up));
        }
        return universalPointVOList;
    }

    @Override
    public List<BlockNamePointVO> findAllBlockNamePointVO() {

        List<BlockNamePointVO> blockNamePointVOList = new ArrayList<>();
        List<Object> listTemp = universalPointRepo.findDistinctByIdAndBlockName();
        int i = 0;
        for (Object cdata: listTemp) {
            i++;
            Object[] obj= (Object[]) cdata;
            Integer id = (Integer)obj[0];
            String name = (String)obj[1];;
            blockNamePointVOList.add(new BlockNamePointVO(id, name));
        }
        return blockNamePointVOList;
    }
}
