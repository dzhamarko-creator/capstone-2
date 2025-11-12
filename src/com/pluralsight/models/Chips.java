package com.pluralsight.models;

public class Chips extends Product {
    public Chips(String flavor) {
        super("Sushki (" + flavor + ")", 1.50);
    }

    @Override
    public double getPrice() { return 1.50; }
}