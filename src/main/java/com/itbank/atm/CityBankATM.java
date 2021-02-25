package com.itbank.atm;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.model.CityBankAccount;
import com.itbank.atm.model.NationalBankAccount;
import com.itbank.atm.service.BankService;
import com.itbank.atm.service.BankServiceImpl;

import java.util.Scanner;

public class CityBankATM {
    public static final Scanner console = new Scanner(System.in);
    public static final BankService service = new BankServiceImpl();
    public static final Integer TAX = 200;

    public static void main(String[] args) {

        System.out.print("Enter your account number: ");
        String accNumber = console.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = console.nextLine();

        BankAccount client = service.getClient(accNumber, pin);

        if (client == null) {
            System.out.println("Incorrect Account number/PIN! Please try again.");
        } else {
            if (client instanceof CityBankAccount) {
                cityBankMenu(client);
            } else if (client instanceof NationalBankAccount) {
                nationalBankMenu(client);
            }
        }

    }

    public static void cityBankMenu(BankAccount client) {
        Integer selector = 0;
        String input;
        while (!selector.equals(6)) {
            printCityBankMenu();
            selector = console.nextInt();
            switch (selector) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    input = console.nextLine();
                    service.withdrawal(client, Integer.parseInt(input));
                    break;
                case 2:
                    System.out.println("Your current balance: " + service.totalBalance(client));
                    break;
                case 3:
                    System.out.print("Enter new PIN: ");
                    input = console.nextLine();
                    service.setPinCode(client, input);
                case 4:
                    System.out.print("Enter amount of funds to replenish: ");
                    input = console.nextLine();
                    service.replenishment(client, Integer.parseInt(input));
                    break;
                case 5:
                    System.out.println(service.accountData(client));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Incorrect input! Please try again\n");
            }
        }
    }

    public static void nationalBankMenu(BankAccount client) {
        Integer selector = 0;
        Integer input;
        while (!selector.equals(3)) {
            printNationalBankMenu();
            selector = console.nextInt();
            if (selector.equals(1)) {
                System.out.print("Enter amount to withdraw: ");
                input = console.nextInt();
                service.withdrawal(client, input + TAX);
            } else if (selector.equals(2)) {
                System.out.println("Your current balance: " + service.totalBalance(client));
            } else {
                System.out.println("Incorrect input! Please try again\n");
            }
        }
    }

    public static void printCityBankMenu() {
        System.out.println("PRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO CHANGE PIN CODE\n" +
                "PRESS [4] TO REFILL ACCOUNT\n" +
                "PRESS [5] TO VIEW ACCOUNT DATA\n" +
                "PRESS [6] TO EXIT");
    }

    public static void printNationalBankMenu() {
        System.out.println("PRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO EXIT");
    }
}
