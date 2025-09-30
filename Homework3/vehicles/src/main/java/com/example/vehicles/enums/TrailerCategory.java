package com.example.vehicles.enums;

public enum TrailerCategory {
    O1("�������, ���������� ���������� ������������ ����� ������� �� ����� 0,75 ����."), 
    O2("�������, ���������� ���������� ������������ ����� ������� ����� 0,75 �, �� �� ����� 3,5 ����."), 
    O3("�������, ���������� ���������� ������������ ����� ������� ����� 3,5 �, �� �� ����� 10 ����."), 
    O4("�������, ���������� ���������� ������������ ����� ������� ����� 10 ����.");

    String description;

    TrailerCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
       return description;
   }
}
