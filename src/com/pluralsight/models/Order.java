package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> items = new ArrayList<>();

    public void addItem(Product item) { items.add(item); }

    public double calculateTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getItems() { return items; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Your Order:\n");
        for (Product item : items)
            sb.append(" - ").append(item).append("\n");
        sb.append("----------------------\n");
        sb.append(String.format("Total: $%.2f", calculateTotal()));
        return sb.toString();
    }
}