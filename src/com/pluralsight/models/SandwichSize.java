package com.pluralsight.models;

public enum SandwichSize {
    MINI(5.50),
    NORMAL(7.00),
    XL(8.50);

    private final double basePrice;
    SandwichSize(double basePrice) { this.basePrice = basePrice; }
    public double getBasePrice() { return basePrice; }
}