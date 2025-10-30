package com.bank;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.AbstractList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.bank.transactions.Transaction;

public class Bank {

    private final Map<Integer, Account> accounts = new ConcurrentHashMap<>();
    private final Map<Currency, Double> exchangeRates = new ConcurrentHashMap<>();
    private final BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final ExecutorService cashierPool;

    Queue<AbstractList<Integer>> queue = new LinkedBlockingQueue<>();

    public Bank(int numCashiers) {
        this.cashierPool = Executors.newFixedThreadPool(numCashiers);
        initExchangeRates();
        initScheduledUpdater();
        IntStream.range(0, numCashiers).forEach(i -> cashierPool.execute(new Cashier(this)));
    }

    public void addOperationLogger(PropertyChangeListener pcl) {
        this.support.addPropertyChangeListener(pcl);
    }

    public void removeOperationLogger(PropertyChangeListener pcl) {
        this.support.removePropertyChangeListener(pcl);
    }

    public void bankNotefire(String propertyName, Object oldValue, Object newValue ) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    } 

    private void initExchangeRates() {
        for(Currency c : Currency.values()) {
            exchangeRates.put(c, c.getExchangeRate());
        }
    }

    private void initScheduledUpdater() {
        scheduler.scheduleAtFixedRate(
            () -> {
                double min = -2;
                double max = 2;
                Random random = new Random();
                double delta = random.nextDouble(max - min + 1) + min;
                    for(Currency c : Currency.values()) {
                        if(!c.equals(Currency.RUB)) {
                            c.setExchangeRate(c.getExchangeRate() + delta);
                            support.firePropertyChange("Обновление курса валюты " + c.name(), false, String.format("Успешно: текущий курс %.2f", c.getExchangeRate()));
                    }
                }
            }, 
        0, 11, TimeUnit.SECONDS);
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
        support.firePropertyChange("Открытие счета", false, 
            String.format("Успешно: открыт счет %d на имя %s с балансом %.2f", account.getId(), account.getClient().name(), account.getBalance()));
    }

    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }

    public Map<Integer, Account> getClientAccounts(Client client) {
        return accounts.entrySet().stream().filter(e -> e.getValue().getClient().equals(client)).collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue));
    }

    public double getExchangeRate(Currency currency) {
        return exchangeRates.getOrDefault(currency, 0.0);
    }

    public void submitTransaction(Transaction transaction) throws InterruptedException {
        transactionQueue.put(transaction);
    }

    public Transaction getTransaction() throws InterruptedException {
        return transactionQueue.take();
    }

    public void shutdown() {
        cashierPool.shutdown();
        scheduler.shutdown();
        support.firePropertyChange("Банк завершает работу.", false, "Работа банка завершена");
    }
}
