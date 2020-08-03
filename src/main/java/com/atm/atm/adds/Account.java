package com.atm.atm.adds;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Account {
    public String accountId;
    public String bankId;
    public String numberAccount;
    public String typeAccount;
    public LocalDate creationDate;
    public double currentBalance;
    public double commission;
    public double commissionInterBank;
    public int transactionsAtm;
    public int transactionsBank;
    public List<String> customerId;
    public List<String> signatories;
}
