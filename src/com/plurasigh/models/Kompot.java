package com.plurasigh.models;

public class Kompot extends Product {
    public Kompot(String name, double price) {
        super(name, price);
    }

    @Override
    public double getPrice() { return price; }
}