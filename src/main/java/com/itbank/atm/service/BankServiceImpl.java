package com.itbank.atm.service;

import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;

public class BankServiceImpl implements BankService {
    @Override
    public BankAccount getClient(String accountNumber, String pinCode) {
        BankAccount client = null;
        for (BankAccount account : Database.getBankAccountList()) {
            if(account.getAccountNumber().equals(accountNumber) && account.getPinCode().equals(pinCode)){
                client = account;
                break;
            }
        }
        return client;
    }

    @Override
    public String getAccountNumber(BankAccount client) {
        return client.getAccountNumber();
    }

    @Override
    public String getPinCode(BankAccount client) {
        return client.getPinCode();
    }

    @Override
    public void setPinCode(BankAccount client, String pinCode) {
        client.setPinCode(pinCode);
    }

    @Override
    public Integer totalBalance(BankAccount client) {
        return client.getBalance();
    }

    @Override
    public void withdrawal(BankAccount client, Integer money) {
        Integer balance = client.getBalance() - money;
        client.setBalance(balance);
    }

    @Override
    public void replenishment(BankAccount client, Integer money) {
        Integer balance = client.getBalance() + money;
        client.setBalance(balance);
    }

    @Override
    public String accountData(BankAccount client) {
        return client.toString();
    }
}
