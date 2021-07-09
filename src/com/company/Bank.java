package com.company;

import java.util.ArrayList;

public class Bank {
    public Bank(String title, float commission) {
        this.title = title;
        changeCommission(commission);
        partners = new ArrayList<Bank>();
    }

    private String title;
    private float commissionPercentage;
    private ArrayList<Bank> partners;

    public float calculateCommission(Bank recipient) {
        if (recipient.partners.contains(this))
            return 0;
        return commissionPercentage;
    }

    public void concludeContract(Bank bank) {
        partners.add(bank);
        bank.partners.add(this);
    }

    public void terminateTheContract(Bank bank) {
        partners.remove(bank);
        bank.partners.remove(this);
    }

    public void changeCommission(float commissionPercentage) {
        this.commissionPercentage = Math.min(0.3F, commissionPercentage);
    }

    public void rename(String newTitle) {
        if (newTitle.length() <= 100) {
            title = newTitle;
        }
    }
}
