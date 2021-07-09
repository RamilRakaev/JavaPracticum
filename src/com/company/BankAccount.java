package com.company;

public class BankAccount {
    private String name;
    private final Bank bank;
    private double state;

    public BankAccount(String name, Bank bank, double startingState) {
        this.name = name;
        this.bank = bank;
        this.state = startingState;
    }

    public void transaction(double amount, BankAccount recipient) {
        double commission = amount * bank.calculateCommission(recipient.bank);
        this.state -= amount;
        recipient.state += amount - commission;
    }

    public double accountStatus() {
        return Math.round(state);
    }

    public void changeName(String newName) {
        if (newName.length() <= 100) {
            name = newName;
        }
    }
}
