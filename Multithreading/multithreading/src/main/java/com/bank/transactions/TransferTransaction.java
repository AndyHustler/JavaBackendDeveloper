package com.bank.transactions;

import com.bank.Transaction;

public class TransferTransaction implements Transaction{
    private final int senderId;
    private final int receiverId;
    private final double amount;

    public TransferTransaction(int senderId, int receiverId, double amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

    public int getSenderId() { 
        return senderId; 
    }

    public int getReceiverId() { 
        return receiverId; 
    }
    
    public double getAmount() { 
        return amount; 
    }
}
