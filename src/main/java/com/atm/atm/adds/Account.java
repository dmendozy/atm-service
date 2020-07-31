package com.atm.atm.adds;

import lombok.Data;

import java.util.List;

@Data
public class Account {
    public String accountId;
    public String numberAccount;
    public String typeAccount;
    public double currentBalance;
    public int transactionsAmount;
    public List<String> customerId;
    public List<String> signatories;
}
