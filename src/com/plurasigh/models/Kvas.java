package com.plurasigh.models;

public class Kvas extends Product {
    public Kvas(String name, double price) {
        super(name, price);
    }

    @Override
    public double getPrice() { return price; }
}