package com.company;

import java.util.ArrayList;

public class BankAccount {

    public BankAccount(String bank, ArrayList<String> partners) {
        this.bank = bank;
        this.partners = partners;
    }

    final float commissionPercentage = 0.3F;
    private ArrayList<String> partners;
    private final String bank;
    private double state;

    public void transaction(double amount, BankAccount recipient) {
        double commission = amount * commissionPercentage;
        for (String partner : partners){
            if(partner == recipient.bank){
                commission = 0;
            }
        }
        this.state = amount;
        recipient.state += amount - commission;
    }
    
    public void addPartner(String bank){
        partners.add(bank);
    }

}
