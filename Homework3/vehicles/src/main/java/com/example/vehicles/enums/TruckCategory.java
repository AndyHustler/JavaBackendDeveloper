package com.example.vehicles.enums;

public enum TruckCategory {
    N1("Транспортные средства, предназначенные для перевозки грузов,\r\n" + 
        "имеющие технически допустимую максимальную массу не более 3,5 тонн."), 
    N2("Транспортные средства, предназначенные для перевозки грузов,\r\n" +
        "имеющие технически допустимую максимальную массу свыше 3,5 тонн, но не более 12 тонн."), 
    N3("Транспортные средства, предназначенные для перевозки грузов,\r\n" + 
        "имеющие технически допустимую максимальную массу более 12 тонн.");

    String description;

    TruckCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
       return description;
   }
}
