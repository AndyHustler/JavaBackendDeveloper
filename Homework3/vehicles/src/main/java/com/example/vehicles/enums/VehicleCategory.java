package com.example.vehicles.enums;

public enum VehicleCategory {
    //L1, L2, L3, L4, L5, L6, L7, M1, M2, M3, N1, N2, N3, O1, O2, O3, O4;
    L("���������������� ��������"), 
    M("������������ ��������, ������� �� ����� ������� ����� � ������������ ��� ��������� ����������"), 
    N("������������ ��������, ������������ ��� ��������� ������ - ���������� �������� � �� �����"), 
    O("������� (�����������) � ������������ ��������� ��������� L, M, N");

    String description;

    VehicleCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
       return description;
   }
}
