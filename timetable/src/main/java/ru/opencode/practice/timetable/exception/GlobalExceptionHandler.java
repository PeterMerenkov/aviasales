package ru.opencode.practice.timetable.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionData> handleExeption(NoSuchCountExeption exeption) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setInfo(exeption.getMessage());
        return new ResponseEntity<>(exceptionData, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionData> handleExeption(Exception exception) {
        ExceptionData exceptionData = new ExceptionData();
        exceptionData.setInfo(exception.getMessage());
        return new ResponseEntity<>(exceptionData, HttpStatus.BAD_REQUEST);
    }
}