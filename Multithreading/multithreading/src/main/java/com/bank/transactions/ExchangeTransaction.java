package com.bank.transactions;

import com.bank.Currency;
import com.bank.Transaction;

public class ExchangeTransaction implements Transaction{
    private final int accountId;
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final double amount;

    public ExchangeTransaction(int accountId, Currency fromCurrency, Currency toCurrency, double amount) {
        this.accountId = accountId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }

    public int getAccountId() { 
        return accountId; 
    }
    
    public Currency getFromCurrency() { 
        return fromCurrency; 
    }
    
    public Currency getToCurrency() { 
        return toCurrency; 
    }
    
    public double getAmount() { 
        return amount; 
    }
}
