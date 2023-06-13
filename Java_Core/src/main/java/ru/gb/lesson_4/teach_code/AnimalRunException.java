package ru.gb.lesson_4.teach_code;

public class AnimalRunException extends AnimalException{
    public AnimalRunException(String message, String name, int distance) {
        super(message, name, distance);
    }
}
