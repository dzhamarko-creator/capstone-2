package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;
import java.util.Scanner;

public class DeliApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean running = true;

        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +

                "⠀⠀⢠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⡄⠀⠀\n" +
                "⠀⠀⣿⣿⣿⣿⣿⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⢹⣿⣿⣿⣿⡟⣿⣿⣿⣿⣿⠀⠀\n" +
                "⠀⠀⣿⣿⣿⣿⡟⢸⣿⣿⣿⣿⢹⣿⣿⣿⣿⡘⣿⣿⣿⣿⡇⢻⣿⣿⣿⣿⠀⠀\n" +
                "⠀⢀⣛⣛⣛⣛⠃⣛⣛⣛⣛⡋⠈⣛⣛⣛⣛⠁⢛⣛⣛⣛⣛⠘⣛⣛⣛⣛⡀⠀\n" +
                "⠀⠈⠻⠿⠿⠋⣀⠈⠻⠿⠟⢁⡀⠙⠿⠿⠋⢀⡈⠻⠿⠟⠁⣀⠙⠿⠿⠟⠁⠀\n" +
                "⠀⢸⣷⣦⣶⣿⣿⣿⣶⣤⣶⣿⣿⣷⣦⣴⣾⣿⣿⣶⣤⣶⣿⣿⣿⣶⣴⣾⡇⠀\n" +
                "⠀⢸⣿⡏⣉⣉⣉⣉⣉⣉⣉⣉⣉⣉⣉⣉⣉⡉⢹⣿⠉⣉⣉⣉⣉⣉⢹⣿⡇⠀\n" +
                "⠀⢸⣿⡇⣿⠉⢉⣩⣭⣽⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⠀⣿⣿⣿⣿⣿⢸⣿⡇⠀\n" +
                "⠀⢸⣿⡇⣿⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⠀⠿⠿⠿⠿⠿⢸⣿⡇⠀\n" +
                "⠀⢸⣿⡇⣿⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⠀⠶⠶⠶⠶⠶⢸⣿⡇⠀\n" +
                "⠀⢸⣿⡇⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⢸⣿⠀⣶⣶⣶⣶⣶⢸⣿⡇⠀\n" +
                "⠀⢸⣿⣷⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿⠀⣿⣿⣿⣿⣿⢸⣿⡇⠀\n" +
                "⠀    \uD83C\uDF54\uD835\uDC16\uD835\uDC04\uD835\uDC0B\uD835\uDC02\uD835\uDC0E\uD835\uDC0C\uD835\uDC04 to Slavic Deli\uD83C\uDF54");
        System.out.println("\uD83D\uDED2 What would you like to order today? \uD83D\uDED2 :");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) \uD83E\uDD6A Pelmenich (Sandwich)");
            System.out.println("2) \uD83C\uDF7A Drinks (Kvas / Kompot / Mors)");
            System.out.println("3) \uD83E\uDD54 Sushki (Chips)");
            System.out.println("4) \uD83E\uDDFE Checkout");
            System.out.println("0) \uD83D\uDEAB Exit");
            System.out.print("☆ What would you like today ☆: ");

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
        System.out.print("\uD83C\uDF5E Bread (BORODINSKY/BLACK_RYE/WHITE/WHEAT): ");
        Bread bread = Bread.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("\uD83D\uDCD0 Size (MINI/NORMAL/XL): ");
        SandwichSize size = SandwichSize.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("\uD83D\uDD25 Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(bread, size, toasted);
        sandwich.addTopping("Kielbasa", true);
        sandwich.addTopping("Cabbage", false);
        return sandwich;
    }

    private static Drink createDrink(Scanner scanner) {
        System.out.println("Choose Drink Type:");
        System.out.println("1) \uD83C\uDF7B Kvas");
        System.out.println("2) \uD83C\uDF53 Kompot");
        System.out.println("3) \uD83E\uDDC9 Mors");
        String type = scanner.nextLine();

        System.out.print("\uD83D\uDCD0 Size (SMALL/MEDIUM/LARGE): ");
        DrinkSize size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());

        return switch (type) {
            case "1" -> new Kvas(size);
            case "2" -> new Kompot(size);
            case "3" -> new Mors(size);
            default -> new Kvas(size);
        };
    }

    private static Chips createChips(Scanner scanner) {
        System.out.print("\uD83E\uDD54 Sushki flavor (Vanilla/Honey/Poppy): ");
        String flavor = scanner.nextLine();
        return new Chips(flavor);
    }
}