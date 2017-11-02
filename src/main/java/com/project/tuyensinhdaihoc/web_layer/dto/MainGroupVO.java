package com.project.tuyensinhdaihoc.web_layer.dto;

public class MainGroupVO {
    private Integer id;
    private String code;
    private String displayName;


    public MainGroupVO() {
    }

    public MainGroupVO(Integer id, String code, String displayName) {
        this.id = id;
        this.code = code;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
