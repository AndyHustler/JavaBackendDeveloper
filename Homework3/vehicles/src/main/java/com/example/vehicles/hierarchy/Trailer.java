package com.example.vehicles.hierarchy;

import com.example.vehicles.enums.VehicleCategory;
import com.example.vehicles.interfaces.TrailerHitchStatus;

public final class Trailer extends Vehicle implements TrailerHitchStatus{

    String hitchType;

    public Trailer(String name, int wheelsNumber, int weight, String hitchType) {
        super(name, wheelsNumber, weight);
        this.hitchType = hitchType;
    }

    @Override
    public void HitchConnected() {
        System.out.println("Trailer Connected");
    }

    @Override
    public void HitchDisabled() {
        System.out.println("Trailer Disabled");
    }

    @Override
    public void function() {
        System.out.println(VehicleCategory.O.getDescription());
    }

}
