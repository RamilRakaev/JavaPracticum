package com.company;

import java.util.ArrayList;

public class Bank {
    Bank(String title, float commission) {
        this.title = title;
        changeCommission(commission);
        partners = new ArrayList<Bank>();
    }

    private String title;
    private float commissionPercentage;
    private ArrayList<Bank> partners;

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

    void rename(String newTitle) {
        if (newTitle.length() <= 100) {
            title = newTitle;
        }
    }
}
