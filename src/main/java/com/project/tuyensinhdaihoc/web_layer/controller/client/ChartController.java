package com.project.tuyensinhdaihoc.web_layer.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("advisory")
public class ChartController {

    @GetMapping("/chart")
    public String showChart(Model model) {
        return "client/graph/chart";
    }
}
