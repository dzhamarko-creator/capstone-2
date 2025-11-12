package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;
import java.util.Scanner;

public class DeliApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean running = true;

        System.out.println("Добро пожаловать в Slavic Deli!");
        System.out.println("Выберите, что хотите заказать:");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) Pelmenich (Sandwich)");
            System.out.println("2) Drinks (Kvas / Kompot / Mors)");
            System.out.println("3) Sushki (Chips)");
            System.out.println("4) Checkout");
            System.out.println("0) Exit");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> order.addItem(createSandwich(scanner));
                case "2" -> order.addItem(createDrink(scanner));
                case "3" -> order.addItem(createChips(scanner));
                case "4" -> {
                    System.out.println(order);
                    ReceiptWriter.writeToFile(order);
                    running = false;
                }
                case "0" -> running = false;
                default -> System.out.println("Неверный ввод!");
            }
        }
    }

    private static Sandwich createSandwich(Scanner scanner) {
        System.out.print("Bread (BORODINSKY/BLACK_RYE/WHITE/WHEAT): ");
        Bread bread = Bread.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Size (MINI/NORMAL/XL): ");
        SandwichSize size = SandwichSize.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(bread, size, toasted);
        sandwich.addTopping("Kielbasa", true);
        sandwich.addTopping("Cabbage", false);
        return sandwich;
    }

    private static Drink createDrink(Scanner scanner) {
        System.out.println("Choose Drink Type:");
        System.out.println("1) Kvas");
        System.out.println("2) Kompot");
        System.out.println("3) Mors");
        String type = scanner.nextLine();

        System.out.print("Size (SMALL/MEDIUM/LARGE): ");
        DrinkSize size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());

        return switch (type) {
            case "1" -> new Kvas(size);
            case "2" -> new Kompot(size);
            case "3" -> new Mors(size);
            default -> new Kvas(size);
        };
    }

    private static Chips createChips(Scanner scanner) {
        System.out.print("Sushki flavor (Vanilla/Honey/Poppy): ");
        String flavor = scanner.nextLine();
        return new Chips(flavor);
    }
}