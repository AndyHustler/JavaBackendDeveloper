package com.example.vehicles.hierarchy;

import com.example.vehicles.enums.PassengerCategory;
import com.example.vehicles.enums.VehicleCategory;

public final class PassengerTransport extends Vehicle implements EngineVehicle{
    /*
     * Финальный класс для описания транспортных средств предназанченных для перевозки пасажиров
     */
    PassengerCategory category;
    int passengerNumber;

    public PassengerTransport(String name, 
                    int wheelsNumber, 
                    int weight, 
                    PassengerCategory category,
                    int passengerNumber) {
        super(name, 
            wheelsNumber, 
            weight);
        this.category = category;
        this.passengerNumber = passengerNumber;
    }

    @Override
    public void function() {
        System.out.println(VehicleCategory.M.getDescription());
    }

    @Override
    public void EnginePower(int power) {
        System.out.println("Passenger Transport Engine Power = " + power);
    }

    @Override
    public void EngineCapacity(int capacity) {
         System.out.println("Passenger Transport Engine Capacity = " + capacity);
    }

    @Override
    public void VehicleSpeed(int speed) {
        System.out.println("Passenger Transport Speed = " + speed);
    }

}
