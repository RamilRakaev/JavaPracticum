package com.company;

enum LightBulbType {LED, Luminescent, Halogen}

public class LightBulb {
    private boolean isWorking;
    private boolean isBroken;
    private final int energyConsumption;
    private double price;
    private final LightBulbType type;
    private final String color;
    private int workDurationInMonths = 6;

    public LightBulb(int energyConsumption, double price, LightBulbType type, String color) {
        this.energyConsumption = energyConsumption;
        this.price = price;
        this.type = type;
        this.color = color;

        if (type == LightBulbType.LED)
            workDurationInMonths += 12;
        if (energyConsumption > 15)
            workDurationInMonths -= 6;
    }

    public void setCondition(boolean value) {
        this.isWorking = value;
    }

    public final void broke() {
            this.isBroken = true;
            this.isWorking = false;
            this.price = 0;
    }

    public final void setPrice(int value) {
        this.price = Math.min(value, 1000);
    }

    public boolean getState() {
        return this.isWorking;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    public double getPrice() {
        return this.price;
    }

    public LightBulbType getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public int getWorkDurationInMonths(int workTerm) {
        return workDurationInMonths - workTerm;
    }

    @Override
    public String toString() {
        return "Condition: " + isWorking + "; "
                + " Energy consumption: " + energyConsumption + " watt; "
                + "Price: " + price + "; "
                + "Type: " + type + "; "
                + "Color: " + color + ". ";
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }
}
