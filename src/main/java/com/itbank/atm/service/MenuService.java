package com.itbank.atm.service;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.model.CityBankAccount;
import com.itbank.atm.model.NationalBankAccount;

import java.util.Scanner;

public class MenuService {
    private Integer tax;
    private BankService bankService;
    private Scanner console;
    private Integer selector;
    private String input;

    public MenuService() {
        tax = 200;
        bankService = new BankServiceImpl();
        console = new Scanner(System.in);
        selector = 0;
    }

    public MenuService(Integer tax, BankService bankService) {
        this.tax = tax;
        this.bankService = bankService;
        this.console = new Scanner(System.in);
        this.selector = 0;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    public void showMenu(BankAccount client) {
        if (client instanceof CityBankAccount) {
            cityBankMenu(client);
        } else if (client instanceof NationalBankAccount) {
            nationalBankMenu(client);
        }
    }

    private void cityBankMenu(BankAccount client) {
        while (!selector.equals(6)) {
            printCityBankMenu();
            selector = console.nextInt();
            if (selector.equals(1)) {
                withdraw(client);
            } else if (selector.equals(2)) {
                System.out.println("Your current balance: " + bankService.totalBalance(client));
            } else if (selector.equals(3)) {
                changePin(client);
            } else if (selector.equals(4)) {
                refill(client);
            } else if (selector.equals(5)) {
                System.out.println(bankService.accountData(client));
            } else {
                System.out.println("Incorrect input! Please try again");
            }
        }
    }

    private void nationalBankMenu(BankAccount client) {
        while (!selector.equals(3)) {
            printNationalBankMenu();
            selector = console.nextInt();
            if (selector.equals(1)) {
                withdraw(client);
            } else if (selector.equals(2)) {
                System.out.println("Your current balance: " + bankService.totalBalance(client));
            } else {
                System.out.println("Incorrect input! Please try again");
            }
        }
    }

    private void withdraw(BankAccount client) {
        System.out.print("Enter amount of money to withdraw: ");
        Integer money = console.nextInt();
        if (client instanceof CityBankAccount) {
            bankService.withdrawal(client, money);
        } else {
            bankService.withdrawal(client, money + tax);
        }
    }

    private void changePin(BankAccount client) {
        System.out.print("Enter new PIN code: ");
        input = console.nextLine();
        bankService.setPinCode(client, input);
    }

    private void refill(BankAccount client) {
        System.out.print("Enter amount of money to replenish: ");
        input = console.nextLine();
        try {
            bankService.replenishment(client, Integer.parseInt(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printCityBankMenu() {
        System.out.println("\nPRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO CHANGE PIN CODE\n" +
                "PRESS [4] TO REFILL ACCOUNT\n" +
                "PRESS [5] TO VIEW ACCOUNT DATA\n" +
                "PRESS [6] TO EXIT");
    }

    private static void printNationalBankMenu() {
        System.out.println("\nPRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO EXIT");
    }
}
