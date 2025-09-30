package com.example.vehicles.enums;

public enum TrailerCategory {
    O1("Прицепы, технически допустимая максимальная масса которых не более 0,75 тонн."), 
    O2("Прицепы, технически допустимая максимальная масса которых свыше 0,75 т, но не более 3,5 тонн."), 
    O3("Прицепы, технически допустимая максимальная масса которых свыше 3,5 т, но не более 10 тонн."), 
    O4("Прицепы, технически допустимая максимальная масса которых более 10 тонн.");

    String description;

    TrailerCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
       return description;
   }
}
