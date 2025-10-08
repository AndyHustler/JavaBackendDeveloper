package com.example;

public class Main {
    public static void main(String[] args) {

        MyStringBuilder sb = new MyStringBuilder("Hello");

        MyListener ls = new MyListener();

        sb.addPropertyChangeListener(ls);

        sb.append(" world!");

    }
}