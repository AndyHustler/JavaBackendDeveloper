package com.example.vehicles.enums;

public enum TruckCategory {
    N1("������������ ��������, ��������������� ��� ��������� ������,\r\n" + 
        "������� ���������� ���������� ������������ ����� �� ����� 3,5 ����."), 
    N2("������������ ��������, ��������������� ��� ��������� ������,\r\n" +
        "������� ���������� ���������� ������������ ����� ����� 3,5 ����, �� �� ����� 12 ����."), 
    N3("������������ ��������, ��������������� ��� ��������� ������,\r\n" + 
        "������� ���������� ���������� ������������ ����� ����� 12 ����.");

    String description;

    TruckCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
       return description;
   }
}
