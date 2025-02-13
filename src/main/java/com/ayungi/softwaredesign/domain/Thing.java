package com.ayungi.softwaredesign.domain;

// Абстрактный класс Thing – базовый для вещей, реализует IInventory
public abstract class Thing implements IInventory {
    protected String name;
    protected int inventoryNumber;

    public Thing(String name, int inventoryNumber) {
        this.name = name;
        this.inventoryNumber = inventoryNumber;
    }

    public String getName() {
        return name;
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
        return getClass().getSimpleName() + " \"" + name + "\" (Инв. № " + inventoryNumber + ")";
    }
}

