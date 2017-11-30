package com.project.tuyensinhdaihoc.web_layer.dto;

import com.project.tuyensinhdaihoc.data_access_layer.model.UniversalPoint;

import java.util.ArrayList;
import java.util.List;

public class UniversalPointVO {
    private Integer id;
    private List<String> labelList;
    private List<Double> valueList;

    public UniversalPointVO() {
    }

    public UniversalPointVO(Integer id, List<String> labelList, List<Double> valueList) {
        this.id = id;
        this.labelList = labelList;
        this.valueList = valueList;
    }

    public UniversalPointVO(UniversalPoint up) {
        setId(up.getId());
        List<String> labels = new ArrayList<>();
        for(int i = 1; i <= 30; i++) {
            labels.add("less" + i);
        }
        List<Integer> values = new ArrayList<>();
        values.add(up.getLess1());
        values.add(up.getLess2());
        values.add(up.getLess3());
        values.add(up.getLess4());
        values.add(up.getLess5());
        values.add(up.getLess6());
        values.add(up.getLess7());
        values.add(up.getLess8());
        values.add(up.getLess9());
        values.add(up.getLess10());
        values.add(up.getLess11());
        values.add(up.getLess12());
        values.add(up.getLess13());
        values.add(up.getLess14());
        values.add(up.getLess15());
        values.add(up.getLess16());
        values.add(up.getLess17());
        values.add(up.getLess18());
        values.add(up.getLess19());
        values.add(up.getLess20());
        values.add(up.getLess21());
        values.add(up.getLess22());
        values.add(up.getLess23());
        values.add(up.getLess24());
        values.add(up.getLess25());
        values.add(up.getLess26());
        values.add(up.getLess27());
        values.add(up.getLess28());
        values.add(up.getLess29());
        values.add(up.getLess30());

        int sum = values.stream().mapToInt(Integer::intValue).sum();
        List<Double> temp = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            temp.add(values.get(i) * 1.0 / (sum * 1.0));
        }
        setLabelList(labels);
        setValueList(temp);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }

    public List<Double> getValueList() {
        return valueList;
    }

    public void setValueList(List<Double> valueList) {
        this.valueList = valueList;
    }
}
