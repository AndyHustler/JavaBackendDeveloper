package com.example.vehicles.hierarchy;

public sealed abstract interface EngineVehicle permits Moto, PassengerTransport, Truck {

    /*
     * ����������� ������������ ���������, ��� �������� ������������ ������� ���������� ����������� ����������
     */
    void EnginePower(int power);
    void EngineCapacity(int capacity);
    void VehicleSpeed(int speed);

}
