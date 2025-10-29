package com.bank;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final int id;
    private double balance;
    private final Currency currency;
    private final Client client;
    private final ReentrantLock lock = new ReentrantLock(true);

    public Account(double balance, Currency currency, Client client) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.balance = balance;
        this.currency = currency;
        this.client = client;
    }

    public int getId(){
        return id;
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public Client getClient() {
        return client;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Счет {" + "id=" + id + ", владелец " + client.name() + ", баланс=" + String.format("%.2f", balance) + ", валюта='" + currency + "'}";
    }
}
