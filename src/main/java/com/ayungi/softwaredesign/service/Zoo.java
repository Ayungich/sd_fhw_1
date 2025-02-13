package com.ayungi.softwaredesign.service;

import com.ayungi.softwaredesign.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Класс Zoo – описывает зоопарк, управляется Spring.
// Содержит коллекции животных и вещей, а также использует VetClinic для проверки животных.
@Component
public class Zoo {
    private final List<Animal> animals;
    private final List<Thing> things;
    private final IVetClinic vetClinic;

    @Autowired
    public Zoo(IVetClinic vetClinic) {
        this.vetClinic = vetClinic;
        this.animals = new ArrayList<>();
        this.things = new ArrayList<>();
    }

    // Добавление животного после проверки ветеринарной клиникой
    public void addAnimal(Animal animal) {
        if (vetClinic.checkAnimal(animal)) {
            animals.add(animal);
            System.out.println("Животное " + animal.getName() + " добавлено в зоопарк.");
        } else {
            System.out.println("Животное " + animal.getName() + " не добавлено в зоопарк.");
        }
    }

    // Добавление вещи
    public void addThing(Thing thing) {
        things.add(thing);
        System.out.println("Вещь \"" + thing.getName() + "\" добавлена в зоопарк.");
    }

    // Общее количество еды, потребляемой животными
    public int getTotalFoodConsumption() {
        int total = 0;
        for (Animal a : animals) {
            total += a.getFood();
        }
        return total;
    }

    // Количество животных
    public int getAnimalCount() {
        return animals.size();
    }

    // Список животных для контактного зоопарка (травоядные с уровнем доброты > 5)
    public List<Animal> getInteractiveAnimals() {
        List<Animal> interactive = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Herbo herb) {
                if (herb.getKindness() > 5) {
                    interactive.add(a);
                }
            }
        }
        return interactive;
    }

    // Список всех инвентаризационных объектов (животные и вещи)
    public List<IInventory> getAllInventoryItems() {
        List<IInventory> inventoryItems = new ArrayList<>();
        inventoryItems.addAll(animals);
        inventoryItems.addAll(things);
        return inventoryItems;
    }
}
