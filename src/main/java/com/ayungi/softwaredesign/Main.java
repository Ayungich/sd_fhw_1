package com.ayungi.softwaredesign;

import com.ayungi.softwaredesign.config.AppConfig;
import com.ayungi.softwaredesign.domain.*;
import com.ayungi.softwaredesign.service.Zoo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

import static com.ayungi.softwaredesign.util.InputUtil.readInt;

class MainApp {
    public static void main(String[] args) {
        try {
            // Инициализируем Spring-контекст
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            Zoo zoo = context.getBean(Zoo.class);
            Scanner scanner = context.getBean(Scanner.class);

            boolean exit = false;
            while (!exit) {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Добавить животное");
                System.out.println("2. Показать отчет по животным (количество и общий расход еды)");
                System.out.println("3. Показать список животных для контактного зоопарка");
                System.out.println("4. Показать инвентаризационные объекты зоопарка");
                System.out.println("5. Добавить вещь");
                System.out.println("0. Выход");
                System.out.print("Ваш выбор: ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        addAnimalFlow(zoo, scanner);
                        break;
                    case "2":
                        System.out.println("\nОтчет по животным:");
                        System.out.println("Количество животных: " + zoo.getAnimalCount());
                        System.out.println("Общий расход еды (кг в день): " + zoo.getTotalFoodConsumption());
                        break;
                    case "3":
                        List<Animal> interactive = zoo.getInteractiveAnimals();
                        System.out.println("\nЖивотные для контактного зоопарка:");

                        if (interactive.isEmpty()) {
                            System.out.println("Нет подходящих животных.");
                        }
                        else {
                            for (Animal a : interactive) {
                                System.out.println(a);
                            }
                        }
                        break;
                    case "4":
                        List<IInventory> inventoryItems = zoo.getAllInventoryItems();
                        System.out.println("\nИнвентаризационные объекты зоопарка:");

                        if (inventoryItems.isEmpty()) {
                            System.out.println("Нет объектов на балансе.");
                        }
                        else {
                            for (IInventory item : inventoryItems) {
                                System.out.println(item.toString());
                            }
                        }
                        break;
                    case "5":
                        addThingFlow(zoo, scanner);
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Неверный выбор. Попробуйте еще раз.");
                }
            }
            System.out.println("Завершение работы приложения.");
            context.close();
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    // Метод для ввода данных и создания животного с проверками
    private static void addAnimalFlow(Zoo zoo, Scanner scanner) {
        System.out.println("\nВыберите тип животного для добавления:");
        System.out.println("1. Обезьяна");
        System.out.println("2. Кролик");
        System.out.println("3. Тигр");
        System.out.println("4. Волк");
        System.out.print("Ваш выбор: ");
        String typeChoice = scanner.nextLine().trim();
        Animal animal;

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым.");
            return;
        }

        int food = readInt(scanner, "Введите количество кг еды в сутки: ");
        int invNum = readInt(scanner, "Введите инвентаризационный номер: ");

        switch (typeChoice) {
            case "1":
                int kindnessMonkey = readInt(scanner, "Введите уровень доброты (целое число): ");
                animal = new Monkey(name, food, invNum, kindnessMonkey);
                break;
            case "2":
                int kindnessRabbit = readInt(scanner, "Введите уровень доброты (целое число): ");
                animal = new Rabbit(name, food, invNum, kindnessRabbit);
                break;
            case "3":
                animal = new Tiger(name, food, invNum);
                break;
            case "4":
                animal = new Wolf(name, food, invNum);
                break;
            default:
                System.out.println("Неверный выбор типа животного.");
                return;
        }
        zoo.addAnimal(animal);
    }

    // Метод для ввода данных и создания вещи с проверками
    private static void addThingFlow(Zoo zoo, Scanner scanner) {
        System.out.println("\nВыберите тип вещи для добавления:");
        System.out.println("1. Стол");
        System.out.println("2. Компьютер");
        System.out.print("Ваш выбор: ");
        String typeChoice = scanner.nextLine().trim();

        System.out.print("Введите наименование вещи: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Наименование не может быть пустым.");
            return;
        }
        int invNum = readInt(scanner, "Введите инвентаризационный номер: ");

        Thing thing;
        switch (typeChoice) {
            case "1":
                thing = new Table(name, invNum);
                break;
            case "2":
                thing = new Computer(name, invNum);
                break;
            default:
                System.out.println("Неверный выбор типа вещи.");
                return;
        }
        zoo.addThing(thing);
    }
}