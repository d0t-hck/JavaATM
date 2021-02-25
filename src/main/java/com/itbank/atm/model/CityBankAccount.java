package com.itbank.atm.model;

public class CityBankAccount extends BankAccount{
    private String name;
    private String surname;

    public CityBankAccount(String name, String surname, Integer balance, String accountNumber, String pinCode) {
        super(balance, accountNumber, pinCode);
        this.name = name;
        this.surname = surname;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "CityBankAccount{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", " + super.toString() +
                '}';
    }
}
