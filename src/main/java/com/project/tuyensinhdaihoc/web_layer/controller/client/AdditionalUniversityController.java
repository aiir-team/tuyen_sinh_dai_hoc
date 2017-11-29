package com.project.tuyensinhdaihoc.web_layer.controller.client;

import com.project.tuyensinhdaihoc.service_layer.UniversityDetailService;
import com.project.tuyensinhdaihoc.web_layer.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import java.util.List;

@Controller
@RequestMapping("university")
@SessionScope
public class AdditionalUniversityController extends BaseController {

    private final UniversityDetailService universityDetailService;

    @Autowired
    public AdditionalUniversityController(UniversityDetailService universityDetailService) {
        this.universityDetailService = universityDetailService;
    }

    @GetMapping("/all")
    public String showAllUnivAdd(Model model) {
        List<UniversityDetailVO> universityDetailVOList = universityDetailService.findAllUniversityDetailVO();
        model.addAttribute("universityDetailVOList", universityDetailVOList);
        return "client/university/view_all";
    }

    @GetMapping("/search")
    public String showSingleUnivAdd(Model model) {
        model.addAttribute("univNameVOList", getUnivNameVOList());
        return "client/university/search_one";
    }

    private List<UnivNameVO> getUnivNameVOList() {
        return universityDetailService.findAllUnivNameVO();
    }


    @RequestMapping(value = "/search/save", method = RequestMethod.POST)
    public String processUnivCode(@RequestParam("univCode") String univCode, Model model) {

        List<UniversityDetailVO> universityDetailVOList = universityDetailService.findAllUniversityDetailVOByUnivCode(univCode);
        model.addAttribute("univNameVOList", getUnivNameVOList());
        model.addAttribute("universityDetailVOList", universityDetailVOList);
        model.addAttribute("univDisplay", universityDetailVOList.get(0).getUnivCode() + " - " + universityDetailVOList.get(0).getUnivName());

        return "client/university/search_one";
    }
}
