package com.company;

enum LightBulbType {LED, luminescent, Halogen}

public class LightBulb {
    public LightBulb() {
    }

    public LightBulb(int energyConsumption, double price, LightBulbType type, String color) {
        this.energyConsumption = energyConsumption;
        this.price = price;
        this.type = type;
        this.color = color;
    }

    private boolean isWorking;
    private boolean isBroken;
    private int energyConsumption;
    private double price;
    private LightBulbType type;
    private String color;

    public final void setCondition(boolean value) {
        this.isWorking = value;
    }

    public final void setServiceability(boolean value) {
        if (value) {
            this.isBroken = false;
            this.isWorking = false;
            this.price = 0;
        }
    }

    public final void setPrice(int value) {
        if (value <= 1000) {
            this.price = value;
        } else {
            this.price = 1000;
        }
    }

    public boolean getCondition(boolean condition) {
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
        if (isBroken)
            return 0;
        int duration = 2 - workTerm;
        if (price > 500)
            duration += 6;
        if (energyConsumption > 15)
            duration -= 6;
        if (type == LightBulbType.LED)
            duration += 12;

        return duration;
    }

    @Override
    public String toString() {
        return "Condition: " + isWorking + "; "
                + " Energy consumption: " + energyConsumption + "watt; "
                + "Price: " + price + "; "
                + "Type: " + type + "; "
                + "Color: " + color + ". ";
    }
}
