package com.atm.atm.adds;

import lombok.*;

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

    public Transaction(String transactionName,double amount,String accountId){
        this.transactionName=transactionName;
        this.amount=amount;
        this.accountId=accountId;
    }
}
