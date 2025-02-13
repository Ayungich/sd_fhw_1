package com.ayungi.softwaredesign.domain;

// Абстрактный класс Herbo – для травоядных, добавляет свойство «доброта»
public abstract class Herbo extends Animal {
    protected int kindness; // уровень доброты

    public Herbo(String name, int food, int inventoryNumber, int kindness) {
        super(name, food, inventoryNumber);
        this.kindness = kindness;
    }

    public int getKindness() {
        return kindness;
    }

    public void setKindness(int kindness) {
        this.kindness = kindness;
    }

    @Override
    public String toString() {
        return super.toString() + ", доброта: " + kindness;
    }
}
