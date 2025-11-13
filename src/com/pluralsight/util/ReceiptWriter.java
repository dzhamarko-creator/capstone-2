package com.pluralsight.util;

import com.pluralsight.models.Order;
import com.pluralsight.models.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void writeToFile(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("Невозможно создать чек: заказ пуст.");
            return;
        }

        // 🧱 Automatically create /receipts folder if missing
        new java.io.File("src/main/resources/receipts").mkdirs();

        // Create unique timestamp for filenames
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String basePath = "src/main/resources/receipts/";
        String txtFile = basePath + "receipt-" + timestamp + ".txt";
        String csvFile = basePath + "receipt-" + timestamp + ".csv";

        try {
            // Write both text and CSV versions of the receipt
            writeTextReceipt(order, txtFile);
            writeCsvReceipt(order, csvFile);

            // Append total to master sales ledger
            writeToMasterCSV(order.calculateTotal());

            System.out.println("▀▄▀▄▀▄ Чеки сохранены ▀▄▀▄▀▄:");
            System.out.println(" - " + txtFile);
            System.out.println(" - " + csvFile);
            System.out.println(" - ✅ Added to master_sales.csv ✅");

        } catch (IOException e) {
            System.out.println("Ошибка при записи чеков: " + e.getMessage());
        }
    }

    // 📜 Text file version
    private static void writeTextReceipt(Order order, String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("===== Slavic Deli Receipt =====\n");
            writer.write(order.toString());
            writer.write("\n----------------------------\n");
            writer.write(String.format("Итого: ₽%.2f%n", order.calculateTotal()));
            writer.write("Спасибо за покупку!\n");
        }
    }

    // 📊 CSV version (for spreadsheet use)
    private static void writeCsvReceipt(Order order, String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Item,Category,Price\n");
            for (Product p : order.getItems()) {
                String category = detectCategory(p);
                writer.write(String.format("\"%s\",\"%s\",%.2f\n",
                        p.getName(), category, p.getPrice()));
            }
            writer.write(String.format(",,Total: %.2f\n", order.calculateTotal()));
        }
    }

    //  total to cumulative
    private static void writeToMasterCSV(double total) throws IOException {
        String path = "src/main/resources/receipts/master_sales.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                    + "," + String.format("%.2f", total) + "\n");
        }
    }

    // Automatically detect category
    private static String detectCategory(Product p) {
        String className = p.getClass().getSimpleName().toLowerCase();
        if (className.contains("sandwich")) return "Sandwich";
        if (className.contains("drink") || className.contains("kvas")
                || className.contains("kompot") || className.contains("mors")) return "Drink";
        if (className.contains("chips")) return "Chips";
        return "Other";
    }
}