package com.project.tuyensinhdaihoc.helper_layer.utils;

import com.project.tuyensinhdaihoc.web_layer.dto.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class InitialData {


    public static List<MainGroupVO> getAllMainGroup() {
        List<MainGroupVO> allMainGroup = new ArrayList<>();
        allMainGroup.add(new MainGroupVO(1, "KT-KT", "Kế toán - Kiểm toán"));
        allMainGroup.add(new MainGroupVO(2, "TC-NH-BH", "Tài chính - Ngân hàng - Bảo hiểm"));
        allMainGroup.add(new MainGroupVO(3, "NG-NG", "Ngoại giao - Ngoại ngữ"));
        allMainGroup.add( new MainGroupVO(4, "L-TA", "Luật - Tòa án"));
        allMainGroup.add(new MainGroupVO(5, "CNTT-TH", "Công nghệ thông tin - tin học"));
        return allMainGroup;
    }

    public static List<ExamBlockVO> getAllExamBlock() {
        List<ExamBlockVO> allExamBlock = new ArrayList<>();
        allExamBlock.add(new ExamBlockVO(1, "A00", "Toán, Vật lí, Hóa học"));
        allExamBlock.add(new ExamBlockVO(2, "B00", "Toán, Hóa học, Sinh học"));
        allExamBlock.add(new ExamBlockVO(3, "C00", "Ngữ văn, Lịch sử, Địa lí"));
        allExamBlock.add(new ExamBlockVO(4, "D01", "Ngữ văn, Toán, Tiếng anh"));
        return allExamBlock;
    }

    public static List<PriorityVO> getAllPriority() {
        List<PriorityVO> allPriority = new ArrayList<>();
        allPriority.add(new PriorityVO(1, "City", "City"));
        allPriority.add(new PriorityVO(2, "Level", "Level University"));
        allPriority.add(new PriorityVO(3, "Type", "Type of University"));
        return allPriority;
    }

    public static List<CityVO> getAllCity() {
        List<CityVO> allCity = new ArrayList<>();
        allCity.add(new CityVO(1, "HN", "Ha Noi"));
        allCity.add(new CityVO(2, "DN", "Da Nang"));
        allCity.add(new CityVO(3, "HCM", "Ho Chi Minh"));
        return allCity;
    }

    public static List<UniTypeVO> getAllTypeUniversity() {
        List<UniTypeVO> allTypeUniversity = new ArrayList<>();
        allTypeUniversity.add(new UniTypeVO(1, "CL", "Công lập"));
        allTypeUniversity.add(new UniTypeVO(2, "DL", "Dân lập"));
        return allTypeUniversity;
    }

    public static List<UniLevelVO> getAllLevelUniversity() {
        List<UniLevelVO> allUniversity = new ArrayList<>();
        allUniversity.add(new UniLevelVO(1, "DH", "Đại học"));
        allUniversity.add(new UniLevelVO(2, "CD", "Cao đẳng"));
        return allUniversity;
    }
}
