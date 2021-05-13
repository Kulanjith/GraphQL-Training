package com.hms.graphQLTraining.domain.vehicle;

public class BaseVehicle {
    private String id;

    private HosePower enginePower;

    public enum HosePower {
        HP_1500,
        HP_3000
    }

    public BaseVehicle(String id, HosePower enginePower) {
        this.id = id;
        this.enginePower = enginePower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HosePower getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(HosePower enginePower) {
        this.enginePower = enginePower;
    }
}
