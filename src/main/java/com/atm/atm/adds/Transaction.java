package com.atm.atm.adds;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Transaction {
    public String transactionId;
    public String transactionName;
    public double amount;
    public double commission;
    public LocalDate datetime;
    public String accountId;
    public String creditId;

    public Transaction(String transactionName,double amount){
        this.transactionName=transactionName;
        this.amount=amount;
    }
}
