package com.example.vehicles.hierarchy;

public sealed abstract class Vehicle permits Trailer, Moto, PassengerTransport, Truck {
    String name;
    int wheelsNumber;
    int weight;

    public Vehicle(String name, int wheelsNumber, int weight) {
        this.name = name;
        this.wheelsNumber = wheelsNumber;
        this.weight = weight;
    }

    public abstract void function();

    public void move() {
        System.out.println(name + " движется");
    }

    public void stop() {
        System.out.println(name + " остановился");
    } 
}
