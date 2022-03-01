package com.example.baza.model.exception;

public class InvalidUniqueIdException extends RuntimeException{
    public InvalidUniqueIdException() {
        super("Invalid unique ID.");
    }
}
