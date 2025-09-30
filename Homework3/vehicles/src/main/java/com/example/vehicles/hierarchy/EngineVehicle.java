package com.example.vehicles.hierarchy;

public sealed abstract interface EngineVehicle permits Moto, PassengerTransport, Truck {

    /*
     * Абстрактный запечатанный интерфейс, для описания транспортных средств обладающих собственным двигателем
     */
    void EnginePower(int power);
    void EngineCapacity(int capacity);
    void VehicleSpeed(int speed);

}
