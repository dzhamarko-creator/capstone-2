package com.pluralsight.util;

import com.pluralsight.models.Order;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeToFile(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("Unable to make a check: order is empty.");
            return;
        }

        String filename = "src/main/resources/receipts/" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("===== Slavic Deli Receipt =====\n");
            writer.write(order.toString());
            writer.write("\nThank you for shopping at Deli Slavic!");
        } catch (IOException e) {
            System.out.println("Error, please try again: " + e.getMessage());
            return;
        }

        System.out.println("Saved: " + filename);
    }
}