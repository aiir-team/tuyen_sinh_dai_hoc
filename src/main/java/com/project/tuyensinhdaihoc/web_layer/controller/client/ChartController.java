package com.project.tuyensinhdaihoc.web_layer.controller.client;

import com.project.tuyensinhdaihoc.service_layer.UniversalPointService;
import com.project.tuyensinhdaihoc.web_layer.dto.UniversalPointVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("advisory")
public class ChartController {

    private final UniversalPointService universalPointService;
    private List<UniversalPointVO> universalPointVOList;

    @Autowired
    public ChartController(UniversalPointService universalPointService) {
        this.universalPointService = universalPointService;
    }

    @GetMapping("/chart")
    public String showChart(Model model) {
        model.addAttribute("universalPointVOList", getUniversalPointVOList());
        return "client/graph/chart";
    }

    private List<UniversalPointVO> getUniversalPointVOList() {
        return universalPointService.findAllUniversalPointVO();
    }
}
