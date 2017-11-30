package com.project.tuyensinhdaihoc.web_layer.controller.client.rest;

import com.project.tuyensinhdaihoc.service_layer.UniversalPointService;
import com.project.tuyensinhdaihoc.web_layer.dto.UniversalPointVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestChartController {

    private final UniversalPointService universalPointService;

    @Autowired
    public RestChartController(UniversalPointService universalPointService) {
        this.universalPointService = universalPointService;
    }

    @RequestMapping(value = "/chart",method = RequestMethod.GET)
    public List<UniversalPointVO> getListChartById(@RequestParam Integer id){
        return universalPointService.findUniversalPointById(id);
    }

    @RequestMapping(value = "/chart/label/",method = RequestMethod.GET)
    public List<UniversalPointVO> getListChartByBlockName(@RequestParam String blockName){
        return universalPointService.findUniversalPointByBlockName(blockName);
    }
}