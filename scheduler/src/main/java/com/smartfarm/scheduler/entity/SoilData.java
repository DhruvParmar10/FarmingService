package com.smartfarm.scheduler.entity;

public class SoilData {
    private Long farmId;
    private double moisture;
    private double ph;

    public SoilData() {
    }

    public SoilData(Long farmId, double moisture, double ph) {
        this.farmId = farmId;
        this.moisture = moisture;
        this.ph = ph;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    @Override
    public String toString() {
        return "SoilData{" +
                "farmId=" + farmId +
                ", moisture=" + moisture +
                ", ph=" + ph +
                '}';
    }
}
