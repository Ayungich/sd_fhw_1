package com.ayungi.softwaredesign.domain;

// Абстрактный класс Predator – для плотоядных животных
public abstract class Predator extends Animal {
    public Predator(String name, int food, int inventoryNumber) {
        super(name, food, inventoryNumber);
    }
}
