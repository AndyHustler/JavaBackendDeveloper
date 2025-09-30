package com.example.vehicles.hierarchy;

import com.example.vehicles.enums.MotoCategory;
import com.example.vehicles.enums.VehicleCategory;

public final class Moto extends Vehicle implements EngineVehicle{
    /*
     * Финальный класс для описания мототранспортных транспортных средств - 
     * мопеды, мотовелосипеды, мокики, мотоциклы, мотороллеры, трициклы, квадрициклы
     */
    MotoCategory category;

    public Moto(String name, 
                int wheelsNumber, 
                int weight, 
                MotoCategory category) {
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
        System.out.println("Moto Engine Power = " + power);
    }

    @Override
    public void EngineCapacity(int capacity) {
         System.out.println("Moto Engine Capacity = " + capacity);
    }

    @Override
    public void VehicleSpeed(int speed) {
        System.out.println("Moto Speed = " + speed);
    }


}
