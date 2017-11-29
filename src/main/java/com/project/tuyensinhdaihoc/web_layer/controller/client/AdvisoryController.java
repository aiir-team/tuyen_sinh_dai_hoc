package com.project.tuyensinhdaihoc.web_layer.controller.client;

import com.project.tuyensinhdaihoc.data_access_layer.model.Subject;
import com.project.tuyensinhdaihoc.helper_layer.utils.InitialData;
import com.project.tuyensinhdaihoc.service_layer.SubjectService;
import com.project.tuyensinhdaihoc.service_layer.UniversityDetailService;
import com.project.tuyensinhdaihoc.web_layer.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
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

    private List<String> branchList;
    private List<String> univLevelList;
    private List<String> subjectList;
    private List<String> geographicList;
    private List<Double> priorityScoreList;
    private List<Double> regionScoreList;


    private final UniversityDetailService universityDetailService;
    private final SubjectService subjectService;

    @Autowired
    public AdvisoryController(UniversityDetailService universityDetailService, SubjectService subjectService) {
        this.universityDetailService = universityDetailService;
        this.subjectService = subjectService;
    }

    @GetMapping("/select-major")
    public String selectMajor(Model model) {
        /*
        model.addAttribute("allMainGroup", getAllMainGroup());
        model.addAttribute("allExamBlock", getAllExamBlock());
        model.addAttribute("allLevelUniversity", getAllLevelUniversity());
        model.addAttribute("allPriority", getAllPriority());
        model.addAttribute("allCity", getAllCity());
        model.addAttribute("allTypeUniversity", getAllTypeUniversity());
            //Add form object to html page. Auto map : attribute with field in html
        model.addAttribute("advisory", new AdvisoryVO());
        */

        model.addAttribute("branchList", getBranchList());
        model.addAttribute("univLevelList", getUnivLevelList());
        model.addAttribute("subjectList", getSubjectList());
        model.addAttribute("geographicList", getGeographicList());
        model.addAttribute("priorityScoreList", getPriorityScoreList());
        model.addAttribute("regionScoreList", getRegionScoreList());


        model.addAttribute("userInputData", initialUserInputData());
        return "client/advisory/select_major";
    }

    @GetMapping("/select-major/result-detail")
    public String getResultDetail(Model model) {
        return "client/advisory/result_detail";
    }

    @PostMapping("/select-major/save")
    public String processAlgorithm(@Valid UserInputVO userInputVO, BindingResult result, RedirectAttributes redirect, Model model) {
        if (result.hasErrors()) {
            System.out.println("Failed to update scenario!");
            return "redirect:/advisory/select-major";
        }

        /* Filter data based on: univLevel, univRegion */
        universityDetailService.HTGQDBasedOn(userInputVO);

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



    public List<String> getBranchList(){
        return universityDetailService.findAllDistinctBranch();
    }

    public List<String> getUnivLevelList() {
        return InitialData.getAllUnivLevelList();
    }

    public List<String> getSubjectList() {
        return universityDetailService.findAllSubject();
    }

    public List<String> getGeographicList() {
        return universityDetailService.findAllUnivGeographic();
    }

    private UserInputVO initialUserInputData() {
        //return InitialData.initUserInputVO();
        List<Subject> subList = subjectService.findFiveSubject();
        UserInputVO userInputVO = new UserInputVO();
        List<SubjectScoreVO> subjectScoreVOList = new ArrayList<>();
        for(Subject sub: subList) {
            subjectScoreVOList.add(new SubjectScoreVO(sub));
        }
        userInputVO.setSubjectScoreVOList(subjectScoreVOList);
        return userInputVO;
    }

    public List<Double> getPriorityScoreList() {
        return InitialData.getAllPriorityScoreList();
    }

    public List<Double> getRegionScoreList() {
        return InitialData.getAllRegionScoreList();
    }
}
