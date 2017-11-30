package com.project.tuyensinhdaihoc.helper_layer.utils;

import com.project.tuyensinhdaihoc.web_layer.dto.WeightVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InitialData {

    public static List<String> getAllUnivLevelList() {
        List<String> temp = new ArrayList<>();
        temp.add("Đại học");
        temp.add("Cao đẳng");
        return temp;
    }

    public static List<Double> getAllPriorityScoreList() {
        List<Double> temp = new ArrayList<>();
        temp.add(0.0);
        temp.add(1.0);
        temp.add(2.0);
        return temp;
    }

    public static List<Double> getAllRegionScoreList() {
        List<Double> temp = new ArrayList<>();
        temp.add(0.0);
        temp.add(0.5);
        temp.add(1.0);
        temp.add(1.5);
        return temp;
    }


    public static List<WeightVO> initSetOfWeights() {        // amount_student, score, rank, main_subject: 10, 8, 6, 6
        List<WeightVO> weightVOList = new ArrayList<>();
        weightVOList.add(new WeightVO(1, "Số lượng thí sinh bổ sung", 2));
        weightVOList.add(new WeightVO(2, "Điểm được tuyển", 3));
        weightVOList.add(new WeightVO(3, "Xếp hạng của trường", 8));
        weightVOList.add(new WeightVO(4, "Xác suất được nhận", 10));
        return weightVOList;
    }

    public static List<Integer> initWeightList() {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            temp.add(i+1);
        }
        return temp;
    }
}
