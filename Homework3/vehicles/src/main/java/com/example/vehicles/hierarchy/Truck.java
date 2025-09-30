package com.example.vehicles.hierarchy;

import com.example.vehicles.enums.TruckCategory;
import com.example.vehicles.enums.VehicleCategory;

public final class Truck extends Vehicle implements EngineVehicle{
    /*
     * Финальный класс для описания транспортных средств предназанченных для перевозки грузов
     */
    TruckCategory category;

    public Truck(String name, 
                int wheelsNumber, 
                int weight, 
                TruckCategory category) {
        super(name, 
            wheelsNumber, 
            weight);
        this.category = category;
    }

    @Override
    public void function() {
        System.out.println(VehicleCategory.L.getDescription());
    }

    @Override
    public void EnginePower(int power) {
        System.out.println("Truck Engine Power = " + power);
    }

    @Override
    public void EngineCapacity(int capacity) {
         System.out.println("Truck Engine Capacity = " + capacity);
    }

    @Override
    public void VehicleSpeed(int speed) {
        System.out.println("Truck Speed = " + speed);
    }

}
