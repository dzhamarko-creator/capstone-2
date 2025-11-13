package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.util.ReceiptWriter;
import java.util.Scanner;

public class DeliApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean running = true;

        System.out.println(
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
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
                        "⠀    ꧁ঔৣ☬ WELCOME to Slavic Deli ☬ঔৣ꧂"
        );

        System.out.println("˚ ༘⋆\uD83D\uDECD\uFE0F｡˚ What would you like to order today?˚ ༘⋆\uD83D\uDECD\uFE0F｡˚");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) 🥪 Pelmenich (Sandwich)");
            System.out.println("2) 🍺 Drinks (Kvas / Kompot / Mors)");
            System.out.println("3) 🥨 Sushki (Chips)");
            System.out.println("4) 🧾 Checkout");
            System.out.println("0) 🚫 Exit");
            System.out.print("☆ Choose option: ");

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
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------------- SANDWICH BUILDER -------------------------

    private static Sandwich createSandwich(Scanner scanner) {
        System.out.print("🥖 Bread (BORODINSKY/BLACK_RYE/WHITE/WHEAT): ");
        Bread bread = Bread.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("📏 Size (MINI/NORMAL/XL): ");
        SandwichSize size = SandwichSize.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("🔥 Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(bread, size, toasted);

        System.out.println("\n🥬 Choose your toppings!");
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("\nSelect a topping category:");
            System.out.println("1) \uD83C\uDF15 Regular");
            System.out.println("2) \uD83E\uDD69 Meats (premium)");
            System.out.println("3) \uD83E\uDDC0 Cheese (premium)");
            System.out.println("4) \uD83E\uDD63 Sauces");
            System.out.println("0) \uD83D\uDEAE Done adding toppings");

            System.out.print("Your choice: ");
            String cat = scanner.nextLine();

            switch (cat) {
                case "1" -> chooseTopping(scanner, sandwich, Toppings.REGULAR, false);
                case "2" -> chooseTopping(scanner, sandwich, Toppings.MEATS, true);
                case "3" -> chooseTopping(scanner, sandwich, Toppings.CHEESES, true);
                case "4" -> chooseTopping(scanner, sandwich, Toppings.SAUCES, false);
                case "0" -> addingToppings = false;
                default -> System.out.println("Invalid option.");
            }
        }

        return sandwich;
    }

    // ---------------------- TOPPING PICKER -------------------------

    private static void chooseTopping(Scanner scanner, Sandwich sandwich,
                                      java.util.List<String> list, boolean premium) {

        System.out.println("\nAvailable toppings:");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ") " + list.get(i));
        }

        System.out.print("Pick topping number (0 to cancel): ");
        String choice = scanner.nextLine();

        try {
            int num = Integer.parseInt(choice);

            if (num == 0) return;

            if (num >= 1 && num <= list.size()) {
                String topping = list.get(num - 1);
                sandwich.addTopping(topping, premium);
                System.out.println("Added: " + topping
                        + (premium ? " (+premium)" : ""));
            } else {
                System.out.println("Number out of range.");
            }
        } catch (Exception e) {
            System.out.println("Invalid number.");
        }
    }

    // ---------------------- DRINKS -------------------------

    private static Drink createDrink(Scanner scanner) {
        System.out.println("Choose Drink Type:");
        System.out.println("1) 🍺 Kvas");
        System.out.println("2) 🍓 Kompot");
        System.out.println("3) 🫐 Mors");

        String type = scanner.nextLine();

        System.out.print("📏 Size (SMALL/MEDIUM/LARGE): ");
        DrinkSize size = DrinkSize.valueOf(scanner.nextLine().toUpperCase());

        return switch (type) {
            case "1" -> new Kvas(size);
            case "2" -> new Kompot(size);
            case "3" -> new Mors(size);
            default -> new Kvas(size);
        };
    }

    // ---------------------- CHIPS -------------------------

    private static Chips createChips(Scanner scanner) {
        System.out.print("🥨 Sushki flavor (Vanilla/Honey/Poppy): ");
        return new Chips(scanner.nextLine());
    }
}
