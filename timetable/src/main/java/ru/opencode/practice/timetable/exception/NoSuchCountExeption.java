package ru.opencode.practice.timetable.exception;

public class NoSuchCountExeption extends RuntimeException{
    public NoSuchCountExeption(String message) {
        super(message);
    }
}