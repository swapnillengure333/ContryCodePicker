package com.swapnillengure.contrycodepickerlibrary;

public class CountryData {
    private String description;
    private String code;
    private int imgId;
    public CountryData(String description, int imgId, String code) {
        this.description = description;
        this.imgId = imgId;
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
