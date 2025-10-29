package com.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum Currency {
    RUB(1, 1.0, "Российский рубль"),
    USD(1, 80.9713, "Доллар США"),
    EUR(1, 94.0820, "Евро"),
    BYN(1, 27.0128, "Белорусский рубль"),
    CNY(1, 11.1921, "Юань"),
    JPY(100, 52.3393, "Иена");

    private int units;
    private double exchangeRate;
    private String currencyName;
    private final Lock lock = new ReentrantLock(true);

    Currency(int units, double exchangeRate, String currencyName) {
        this.units = units;
        this.exchangeRate = exchangeRate;
        this.currencyName = currencyName;
    }

    public int getUnits() {
        return units;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setExchangeRate(double newExchangeRate) {
        lock.lock();
        try {
            //units = newUnits;
            exchangeRate = newExchangeRate;
            //currencyName = newCurrencyName;
        } finally {
            lock.unlock();
        }
        
    }
}
