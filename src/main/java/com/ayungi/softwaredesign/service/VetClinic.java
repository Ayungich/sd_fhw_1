package com.ayungi.softwaredesign.service;

import com.ayungi.softwaredesign.domain.Animal;
import com.ayungi.softwaredesign.domain.IVetClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

// Реализация ветеринарной клиники, управляется Spring (сканер внедряется через конструктор)
@Component
class VetClinic implements IVetClinic {
    private final Scanner scanner;

    @Autowired
    public VetClinic(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean checkAnimal(Animal animal) {
        System.out.println("Проводится медицинский осмотр для животного: " + animal.getName());
        System.out.print("Введите состояние животного (здоров / не здоров): ");
        String status = scanner.nextLine().trim().toLowerCase();
        boolean isHealthy = status.equals("здоров") || status.equals("здорова") || status.equals("здорово");
        if (isHealthy) {
            System.out.println("Животное " + animal.getName() + " признано здоровым и принято.");
        } else {
            System.out.println("Животное " + animal.getName() + " не прошло осмотр.");
        }
        return isHealthy;
    }
}
