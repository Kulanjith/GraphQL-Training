package com.hms.graphQLTraining.domain.vehicle;

public class Van extends BaseVehicle {
    private boolean isOffRoad;

    public Van(String id, HosePower enginePower, boolean isOffRoad) {
        super(id, enginePower);
        this.isOffRoad = isOffRoad;
    }

    public boolean isOffRoad() {
        return isOffRoad;
    }

    public void setOffRoad(boolean offRoad) {
        isOffRoad = offRoad;
    }
}
