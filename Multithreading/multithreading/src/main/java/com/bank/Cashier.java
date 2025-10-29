package com.bank;

import java.util.Map;

import com.bank.transactions.ExchangeTransaction;
import com.bank.transactions.TransferTransaction;

public class Cashier implements Runnable {

    private final Bank bank;

    public Cashier(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Transaction transaction = bank.getTransaction();
                processTransaction(transaction);
                Thread.sleep(10000); // Имитация времени обработки
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void processTransaction(Transaction transaction) {
        if (transaction instanceof TransferTransaction) {
            TransferTransaction transfer = (TransferTransaction) transaction;
            Account sender = bank.getAccount(transfer.getSenderId());
            Account receiver = bank.getAccount(transfer.getReceiverId());
            String operation = String.format("Превод средств в сумме %.2f от клиента %s со счета %d в валюте %s к клиенту %s на счет %d в валюте %s", 
                transfer.getAmount(), sender.getClient().name(), sender.getId(), sender.getCurrency().name(), receiver.getClient().name(), receiver.getId(), receiver.getCurrency().name());
            if (sender == null || receiver == null) {
                bank.bankNotefire("Ошибка перевода", true, "один из счетов не найден");
                return;
            }

            // Блокировка в порядке ID для предотвращения взаимоблокировок
            Account firstLock = sender.getId() < receiver.getId() ? sender : receiver;
            Account secondLock = sender.getId() < receiver.getId() ? receiver : sender;

            firstLock.getLock().lock();
            try {
                secondLock.getLock().lock();
                try {
                    if (!sender.getCurrency().equals(receiver.getCurrency())) {
                        bank.bankNotefire(operation, true, "Ошибка: валюты счетов не совпадают");
                        return;
                    }
                    if (sender.withdraw(transfer.getAmount())) {
                        receiver.deposit(transfer.getAmount());
                        bank.bankNotefire(operation, false, String.format("Успешно: клиент %s отправил %.2f %s клиенту %s.",
                                sender.getClient().name(), transfer.getAmount(), sender.getCurrency(), receiver.getClient().name()));
                    } else {
                        bank.bankNotefire(operation, true, String.format("Ошибка: недостаточно средств у клиента %s.", sender.getClient().name()));
                    }
                } finally {
                    secondLock.getLock().unlock();
                }
            } finally {
                firstLock.getLock().unlock();
            }
        } else if (transaction instanceof ExchangeTransaction) {
            ExchangeTransaction exchange = (ExchangeTransaction) transaction;
            Account fromAccount = bank.getAccount(exchange.getAccountId());
            
            if (fromAccount == null) {
                bank.bankNotefire("Обмен валюты", true, "Ошибка: счет не найден");
                return;
            }
            String operation = String.format("Клиент %s совершает обмен валюты в сумме %.2f %s на %s", 
                fromAccount.getClient().name(), exchange.getAmount(), exchange.getToCurrency().name(), exchange.getToCurrency().name());
            fromAccount.getLock().lock();
            try {
                if (!fromAccount.getCurrency().equals(exchange.getFromCurrency())) {
                    bank.bankNotefire(operation, true, 
                        String.format("Ошибка несоответствия валют: требуется %s, валюта счета %s", exchange.getFromCurrency().name(), fromAccount.getCurrency().name()));
                    return;
                }

                Map<Integer, Account> clientAccounts = bank.getClientAccounts(fromAccount.getClient());
                Account toAccount = null;
                for(Account a : clientAccounts.values()) {
                    if(a.getCurrency().equals(exchange.getToCurrency())) {
                        toAccount = a;
                        break;
                    }
                }
                if(toAccount == null) {
                    toAccount = new Account(0, exchange.getToCurrency(), fromAccount.getClient());
                    bank.addAccount(toAccount);
                }
                toAccount.getLock().lock();
                try {
                    double rate = bank.getExchangeRate(exchange.getToCurrency());
                    if (rate > 0 && fromAccount.withdraw(exchange.getAmount())) {
                        double convertedAmount = exchange.getAmount() * rate;
                        toAccount.deposit(convertedAmount);
                        bank.bankNotefire(operation, false, String.format("Успешно: клиент %s обменял %.2f %s на %.2f %s", 
                                toAccount.getClient().name(), exchange.getAmount(), exchange.getFromCurrency().name(), toAccount.getBalance(), toAccount.getCurrency().name()));
                    }
                } finally {
                    toAccount.getLock().unlock();
                }
            } finally {
                fromAccount.getLock().unlock();
            }
        }
    }
}
