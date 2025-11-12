package com.plurasigh.models;

public class Mors extends Product {
    public Mors(String name, double price) {
        super(name, price);
    }

    @Override
    public double getPrice() { return price; }
}