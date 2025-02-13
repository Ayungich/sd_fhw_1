package com.ayungi.softwaredesign.domain;

// Интерфейс для ветеринарной клиники
public interface IVetClinic {
    // Метод проверки животного: возвращает true, если животное здорово
    boolean checkAnimal(Animal animal);
}
