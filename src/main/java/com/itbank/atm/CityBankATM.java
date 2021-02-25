package com.itbank.atm;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.service.BankService;
import com.itbank.atm.service.BankServiceImpl;

import java.util.Scanner;

public class CityBankATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account number: ");
        String accNumber = scanner.nextLine();
        String pin = scanner.nextLine();

        BankService service = new BankServiceImpl();
        BankAccount client = service.getClient(accNumber, pin);
        System.out.println(client.toString());

    }
}
