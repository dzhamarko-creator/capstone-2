package com.pluralsight.models;

public class Drink extends com.pluralsight.models.Product {
    private DrinkSize size;

    public Drink(String name, DrinkSize size) {
        super(name + " (" + size.name().toLowerCase() + ")", size.getPrice());
        this.size = size;
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }
}