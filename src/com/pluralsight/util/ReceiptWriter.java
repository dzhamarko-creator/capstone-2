package com.pluralsight.util;

import com.pluralsight.models.Order;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeToFile(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("Невозможно создать чек: заказ пуст.");
            return;
        }

        String filename = "src/main/resources/receipts/" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("===== Slavic Deli Receipt =====\n");
            writer.write(order.toString());
            writer.write("\nСпасибо за покупку!");
        } catch (IOException e) {
            System.out.println("Ошибка при записи чека: " + e.getMessage());
            return;
        }

        System.out.println("Чек сохранён: " + filename);
    }
}