package com.ayungi.softwaredesign.util;

import java.util.Scanner;

public class InputUtil {
    // Метод для безопасного считывания целого числа из консоли
    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Ввод не должен быть пустым. Попробуйте ещё раз.");
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
    }
}
