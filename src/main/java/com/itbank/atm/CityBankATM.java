package com.itbank.atm;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.service.BankService;
import com.itbank.atm.service.BankServiceImpl;
import com.itbank.atm.service.MenuService;

import java.util.Scanner;

public class CityBankATM {
    public static final Scanner console = new Scanner(System.in);
    public static final BankService bankService = new BankServiceImpl();

    public static void main(String[] args) {

        System.out.print("Enter your account number: ");
        String accNumber = console.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = console.nextLine();

        BankAccount client = bankService.getClient(accNumber, pin);
        MenuService menuService = new MenuService();

        if (client == null) {
            System.out.println("Incorrect Account number/PIN! Please try again.");
        } else {
            menuService.showMenu(client);
        }
    }
}
