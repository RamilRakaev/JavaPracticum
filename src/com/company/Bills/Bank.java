package com.company.Bills;

import java.util.ArrayList;

public class Bank {
    Bank(int title, float commission) {
        this.id = title;
        changeCommission(commission);
        partners = new ArrayList<Bank>();
    }

    private int id;
    private float commissionPercentage;
    private ArrayList<Bank> partners;
    private double assets;

    public void commissionDeduction(double amount) {
        assets += amount;
    }

    float calculateCommission(Bank recipient) {
        if (recipient.partners.contains(this))
            return 0;
        return commissionPercentage;
    }

    void concludeContract(Bank bank) {
        partners.add(bank);
        bank.partners.add(this);
    }

    void terminateTheContract(Bank bank) {
        partners.remove(bank);
        bank.partners.remove(this);
    }

    void changeCommission(float commissionPercentage) {
        this.commissionPercentage = Math.min(0.3F, commissionPercentage);
    }
}
