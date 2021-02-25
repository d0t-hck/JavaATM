package com.itbank.atm.dao;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.model.CityBankAccount;
import com.itbank.atm.model.NationalBankAccount;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<BankAccount> bankAccountList = new ArrayList<>();

    static {
        bankAccountList.add(new CityBankAccount("Alex", "Robertson", 20000, "kz3552", "9999"));
        bankAccountList.add(new CityBankAccount("Mike", "Tacker", 40000, "kz2241", "2431"));
        bankAccountList.add(new CityBankAccount("Billy", "Elroy", 80000, "kz1441", "4432"));
        bankAccountList.add(new CityBankAccount("Thorsten", "Borton", 3500000, "kz6268", "7847"));
        bankAccountList.add(new CityBankAccount("Kettie", "Charlesworth", 280000, "kz9374", "7027"));
        bankAccountList.add(new CityBankAccount("Franklin", "Balstone", 800000, "kz2958", "5614"));
        bankAccountList.add(new NationalBankAccount("Alihan Ibrashev", 4000000, "kz4521", "7777"));
        bankAccountList.add(new NationalBankAccount("Bridgette Tamburo", 900000, "kz7725", "8670"));
        bankAccountList.add(new NationalBankAccount("Richart Steffan", 4150000, "kz2116", "3039"));
        bankAccountList.add(new NationalBankAccount("Crista Garthshore", 95000, "kz7313", "3735"));
    }

    public static List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }
}
