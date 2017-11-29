package com.project.tuyensinhdaihoc.service_layer.impl;

import com.project.tuyensinhdaihoc.data_access_layer.model.Combination;
import com.project.tuyensinhdaihoc.data_access_layer.model.Subject;
import com.project.tuyensinhdaihoc.data_access_layer.model.UniversityDetail;
import com.project.tuyensinhdaihoc.data_access_layer.repository.CombinationRepo;
import com.project.tuyensinhdaihoc.data_access_layer.repository.SubjectRepo;
import com.project.tuyensinhdaihoc.data_access_layer.repository.UniversityDetailRepo;
import com.project.tuyensinhdaihoc.helper_layer.utils.Algo;
import com.project.tuyensinhdaihoc.helper_layer.utils.Calculate;
import com.project.tuyensinhdaihoc.service_layer.UniversityDetailService;
import com.project.tuyensinhdaihoc.web_layer.dto.CombinationVO;
import com.project.tuyensinhdaihoc.web_layer.dto.SubjectScoreVO;
import com.project.tuyensinhdaihoc.web_layer.dto.UniversityDetailVO;
import com.project.tuyensinhdaihoc.web_layer.dto.UserInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityDetailServiceImpl implements UniversityDetailService {

    private final UniversityDetailRepo universityDetailRepo;
    private final SubjectRepo subjectRepo;
    private final CombinationRepo combinationRepo;

    @Autowired
    public UniversityDetailServiceImpl(UniversityDetailRepo universityDetailRepo, SubjectRepo subjectRepo, CombinationRepo combinationRepo) {
        this.universityDetailRepo = universityDetailRepo;
        this.subjectRepo = subjectRepo;
        this.combinationRepo = combinationRepo;
    }


    @Override
    public List<String> findAllDistinctBranch() {
        return universityDetailRepo.findAllDistinctBranchName();
    }

    @Override
    public List<String> findAllSubject() {
        List<String> returnList = new ArrayList<>();
        List<Subject> temp = subjectRepo.findAll();
        for(Subject sub: temp) {
            returnList.add(sub.getName());
        }
        return returnList;
    }

    @Override
    public List<String> findAllUnivGeographic() {
        return universityDetailRepo.findAllDistinctUniversityGeographic();
    }


    @Override
    public List<UniversityDetailVO> HTGQDBasedOn(UserInputVO userInputVO) {
        //1. Lam tron diem
        userInputVO = Calculate.roundScore(userInputVO);

        //2. Tinh diem cac to hop co the tao ra trong 5 mon nay
        List<CombinationVO> combinationVOList = new ArrayList<>();
        List<SubjectScoreVO> subjectScoreVOS = userInputVO.getSubjectScoreVOList();
        for(int i = 0; i < 3; i++) {
            for(int j = i+1; j < 4; j++) {
                for(int k = j + 1; k < 5; k++) {
                    List<Combination> cb = combinationRepo.findByIdSub1AndIdSub2AndIdSub3(subjectScoreVOS.get(i).getId(),
                            subjectScoreVOS.get(j).getId(), subjectScoreVOS.get(k).getId());
                    if (cb != null && !cb.isEmpty()) {
                        combinationVOList.add(new CombinationVO(cb.get(0), subjectScoreVOS.get(i), subjectScoreVOS.get(j),
                                subjectScoreVOS.get(k), userInputVO.getPriorityScore(), userInputVO.getRegionScore()));
                    }
                }
            }
        }

        //3. Filter data based on : univLevel, univRegion, totalScore
        List<UniversityDetail> universityDetailList = new ArrayList<>();
        for(CombinationVO comb: combinationVOList) {
            List<UniversityDetail> list = universityDetailRepo.
                    findAllByUnivLevelAndGeographicAndCombinationCodeAndTotalScoreLessThan(
                            userInputVO.getUnivLevel(), userInputVO.getUnivRegion(),
                            comb.getCode(), comb.getTotalScore());
            universityDetailList.addAll(list);


        }

        //4. Prepare input matrix

        int matrixSize = universityDetailList.size();
        int[] arrayId = new int[matrixSize];
        double[] amountStudent = new double[matrixSize];
        double[] score = new double[matrixSize];
        double[] rank = new double[matrixSize];
        double[] mainSubject = new double[matrixSize];

        for(int i = 0; i < matrixSize; i++) {
            UniversityDetail univ = universityDetailList.get(i);
            arrayId[i] = univ.getId();
            amountStudent[i] = (double) univ.getAmountStudent();
            score[i] = univ.getTotalScore();
            rank[i] = (double) univ.getUnivRank();

            String subName = "";
            for (CombinationVO comVO : combinationVOList) {
                if (univ.getCombinationCode().equals(comVO.getCode())) {
                    subName = comVO.getSubName1();
                }
            }
            Double mainScore = 0.0;
            for (SubjectScoreVO subVO : subjectScoreVOS) {
                if (subName.equals(subVO.getSubName())) {
                    mainScore = subVO.getSubScore();
                }
            }

            mainSubject[i] = mainScore;
        }


        //5. Run algorithms
        Integer[] outputResult = Algo.modelTOPSIS(arrayId, amountStudent, score, rank, mainSubject, Algo.oriWeight);

        for(int j = 0; j < outputResult.length; j++) {
            System.out.println(outputResult[j]);
        }

        //6. Show result

        return null;
    }

}
