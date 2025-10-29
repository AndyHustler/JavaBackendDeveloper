package com.bank;

import com.bank.transactions.ExchangeTransaction;
import com.bank.transactions.TransferTransaction;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        //Создаем банк с 3 кассами
        Bank bank = new Bank(3);
        //Создаем слушателя банковких операций и подписываем на сщбытия банка
        OperationLogger logger = new OperationLogger();
        bank.addOperationLogger(logger);
        
        //Создаем клиентов
        Client adam = new Client("Adam");
        Client benjamin = new Client("Benjamin");
        Client charlotte = new Client("Charlotte");
        Client daniel = new Client("Daniel");
        Client emma = new Client("Emma");

        //Открываем счета для клиентов
        Account adamsAccountRub = new Account(10000, Currency.RUB, adam);
        Account adamsAccountUsd = new Account(10000, Currency.USD, adam);
        Account benjaminsAccountRub = new Account(10000, Currency.RUB, benjamin);
        Account benjaminsAccountEur = new Account(10000, Currency.EUR, benjamin);
        Account charlottesAccountRub = new Account(10000, Currency.RUB, charlotte);
        Account danielsAccountByn = new Account(10000, Currency.BYN, daniel);
        Account emmasAccountRub = new Account(10000, Currency.RUB, emma);

        bank.addAccount(adamsAccountRub);
        bank.addAccount(adamsAccountUsd);
        bank.addAccount(benjaminsAccountRub);
        bank.addAccount(benjaminsAccountEur);
        bank.addAccount(charlottesAccountRub);
        bank.addAccount(danielsAccountByn);
        bank.addAccount(emmasAccountRub);

        // Имитация транзакций
        bank.submitTransaction(new TransferTransaction(adamsAccountRub.getId(), benjaminsAccountEur.getId(), 100)); // Перевод RUB->EUR (неудачно из-за разной валюты)
        bank.submitTransaction(new ExchangeTransaction(charlottesAccountRub.getId(), Currency.RUB, Currency.EUR, 200));
        bank.submitTransaction(new ExchangeTransaction(danielsAccountByn.getId(), Currency.RUB, Currency.BYN, 100));
        bank.submitTransaction(new TransferTransaction(emmasAccountRub.getId(), adamsAccountRub.getId(), 50000)); // Перевод RUB->RUB
        bank.submitTransaction(new ExchangeTransaction(emmasAccountRub.getId(), Currency.RUB, Currency.CNY, 50));
        bank.submitTransaction(new TransferTransaction(charlottesAccountRub.getId(), benjaminsAccountEur.getId(), 200)); // Перевод RUB->EUR (неудачно)
        
        // Дать время на обработку
        Thread.sleep(60000);

        bank.shutdown();
    }
}