package com.project.tuyensinhdaihoc.helper_layer.utils;

import com.project.tuyensinhdaihoc.web_layer.dto.SubjectScoreVO;
import com.project.tuyensinhdaihoc.web_layer.dto.UserInputVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calculate {

    /*
           0,00 đến 0,12 thành 0,00
           0,13 đến 0,37 thành 0,25
           0,38 đến 0,62 thành 0,50
           0,63 đến 0,87 thành 0,75
           0,88 đến 0,99 thành 1,00.
   */

    public static UserInputVO roundScore(UserInputVO userInputVO) {
        List<SubjectScoreVO> subjectScoreVOList = userInputVO.getSubjectScoreVOList();
        for(SubjectScoreVO sub: subjectScoreVOList) {
            sub.setSubScore(round(sub.getSubScore()));
        }
        userInputVO.setSubjectScoreVOList(subjectScoreVOList);
        return userInputVO;
    }

    public static Double round(Double d) {
        String s = String.format("%.2f", d);
        Double value = Double.valueOf(s.split("\\.")[0]);
        int t1 = Integer.valueOf(s.split("\\.")[1]);;
        if(13 <= t1 && t1 <= 37) {
            value += 0.25;
        } else if (38 <= t1 && t1 <= 62) {
            value += 0.50;
        } else if (63 <= t1 && t1 <= 87) {
            value += 0.75;
        } else if (88 <= t1 && t1 <= 99) {
            value += 1.0;
        }
        return value;
    }

}
