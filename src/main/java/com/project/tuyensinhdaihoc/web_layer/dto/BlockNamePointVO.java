package com.project.tuyensinhdaihoc.web_layer.dto;

public class BlockNamePointVO {
    private int id;
    private String blockName;

    public BlockNamePointVO() {
    }

    public BlockNamePointVO(int id, String blockName) {
        this.id = id;
        this.blockName = blockName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}
