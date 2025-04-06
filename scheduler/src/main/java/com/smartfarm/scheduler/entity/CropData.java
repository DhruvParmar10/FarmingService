package com.smartfarm.scheduler.entity;

public class CropData {
    private Long id;

    private int farmId;
    private String cropType;

    public CropData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int  farmId) {
        this.farmId = farmId;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(String growthStage) {
        this.growthStage = growthStage;
    }

    public CropData(double expectedYield, String growthStage, String cropType, int farmId) {
        this.expectedYield = expectedYield;
        this.growthStage = growthStage;
        this.cropType = cropType;
        this.farmId = farmId;
    }

    public double getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(double expectedYield) {
        this.expectedYield = expectedYield;
    }

    private String growthStage;
    private double expectedYield;

}
