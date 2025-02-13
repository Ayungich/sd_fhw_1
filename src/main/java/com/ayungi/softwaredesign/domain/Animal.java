package com.ayungi.softwaredesign.domain;

// Абстрактный класс Animal – базовый для всех животных, реализует IAlive и IInventory
public abstract class Animal implements IAlive, IInventory {
    protected String name;
    protected int food;
    protected int inventoryNumber;

    public Animal(String name, int food, int inventoryNumber) {
        this.name = name;
        this.food = food;
        this.inventoryNumber = inventoryNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public int getNumber() {
        return inventoryNumber;
    }

    @Override
    public void setNumber(int number) {
        this.inventoryNumber = number;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " \"" + name + "\" (Инв. № " + inventoryNumber + ", еда: " + food + " кг/день)";
    }
}

