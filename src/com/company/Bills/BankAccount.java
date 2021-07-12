package com.company.Bills;

public class BankAccount {
    private int id;
    private final Bank bank;
    private double balance;

    public BankAccount(int id, Bank bank, double startingState) {
        this.id = id;
        this.bank = bank;
        this.balance = startingState;
    }

    public String transfer(double amount, BankAccount recipient) {
        double commission = amount * bank.calculateCommission(recipient.bank);
        if (balance >= amount) {
            this.balance -= amount;
            recipient.balance += amount - commission;
            bank.commissionDeduction(commission);
            return "Transfer completed successfully";
        }
        else {
            return "There is not enough money in the account";
        }
    }

    public double accountStatus() {
        return balance;
    }
}
