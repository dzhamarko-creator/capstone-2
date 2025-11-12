package com.plurasigh.deli;

import com.plurasigh.models.Kompot;
import com.plurasigh.models.Kvas;
import com.plurasigh.models.Mors;

import java.util.Scanner;

public class DrinkApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Добро пожаловать в Slavic Deli!");
        System.out.println("Try one of our traditional drinks.");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) Kvas (Bread Drink) - $2.00");
            System.out.println("2) Kompot (Fruit Drink) - $2.50");
            System.out.println("3) Mors (Berry Drink) - $3.00");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    Kvas kvas = new Kvas("Kvas", 2.00);
                    System.out.println("You selected: " + kvas.getName() + " | Price: $" + kvas.getPrice());
                }
                case "2" -> {
                    Kompot kompot = new Kompot("Kompot", 2.50);
                    System.out.println("You selected: " + kompot.getName() + " | Price: $" + kompot.getPrice());
                }
                case "3" -> {
                    Mors mors = new Mors("Mors", 3.00);
                    System.out.println("You selected: " + mors.getName() + " | Price: $" + mors.getPrice());
                }
                case "0" -> {
                    System.out.println("До свидания!");
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}