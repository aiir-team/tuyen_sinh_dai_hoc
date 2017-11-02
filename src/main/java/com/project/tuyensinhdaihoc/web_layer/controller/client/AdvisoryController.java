package com.project.tuyensinhdaihoc.web_layer.controller.client;

import com.project.tuyensinhdaihoc.helper_layer.utils.InitialData;
import com.project.tuyensinhdaihoc.web_layer.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("advisory")
@SessionScope
public class AdvisoryController extends BaseController {


    private List<MainGroupVO> allMainGroup;
    private List<ExamBlockVO> allExamBlock;
    private List<UniLevelVO> allLevelUniversity;
    private List<PriorityVO> allPriority;
    private List<CityVO> allCity;
    private List<UniTypeVO> allTypeUniversity;


    @GetMapping("/select-major")
    public String selectMajor(Model model) {
        model.addAttribute("allMainGroup", getAllMainGroup());
        model.addAttribute("allExamBlock", getAllExamBlock());
        model.addAttribute("allLevelUniversity", getAllLevelUniversity());
        model.addAttribute("allPriority", getAllPriority());
        model.addAttribute("allCity", getAllCity());
        model.addAttribute("allTypeUniversity", getAllTypeUniversity());

        model.addAttribute("advisory", new AdvisoryVO());                   /* Add form object to html page. Auto map : attribute with field in html*/
        return "client/advisory/select_major";
    }

    @GetMapping("/select-major/result-detail")
    public String getResultDetail(Model model) {
        return "client/advisory/result_detail";
    }

    @PostMapping("/select-major/save")
    public String processAlgorithm(@Valid AdvisoryVO advisoryVO, BindingResult result, RedirectAttributes redirect, Model model) {
        if (result.hasErrors()) {
            System.out.println("Failed to update scenario!");
            return "redirect:/advisory/select-major";
        }

        /* Code giai thuat se nam o day. */

        /* End */


        /* Add cac model ket qua vao day, roi truyen ra ngoai page*/
        return "client/advisory/result_university";
    }



    public List<MainGroupVO> getAllMainGroup() {
        return InitialData.getAllMainGroup();
    }

    public List<ExamBlockVO> getAllExamBlock() {
        return InitialData.getAllExamBlock();
    }

    public List<UniLevelVO> getAllLevelUniversity() {
        return InitialData.getAllLevelUniversity();
    }

    public List<PriorityVO> getAllPriority() {
        return InitialData.getAllPriority();
    }

    public List<CityVO> getAllCity() {
        return InitialData.getAllCity();
    }

    public List<UniTypeVO> getAllTypeUniversity() {
        return InitialData.getAllTypeUniversity();
    }
}
