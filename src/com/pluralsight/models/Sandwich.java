package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private Bread bread;
    private SandwichSize size;
    private boolean toasted;
    private final List<String> toppings = new ArrayList<>();

    public Sandwich(Bread bread, SandwichSize size, boolean toasted) {
        super(size.name() + " " + bread.name() + " Pelmenich", size.getBasePrice());
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
    }

    public void addTopping(String topping, boolean premium) {
        toppings.add(topping);
        if (premium) {
            switch (size) {
                case MINI -> price += 1.00;
                case NORMAL -> price += 2.00;
                case XL -> price += 3.00;
            }
        }
    }

    @Override
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + (toasted ? " (Toasted)" : "") +
                " | Fillings: " + toppings + " | ₽" + String.format("%.2f", price);
    }
}
