package com.project.tuyensinhdaihoc.web_layer.dto;

public class UnivNameVO {
    private Integer id;
    private String code;
    private String name;
    private String displayName;

    public UnivNameVO(Integer id, String code, String name, String displayName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.displayName = displayName;
    }

    public UnivNameVO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
