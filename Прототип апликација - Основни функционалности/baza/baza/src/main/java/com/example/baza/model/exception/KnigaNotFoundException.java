package com.example.baza.model.exception;

public class KnigaNotFoundException extends RuntimeException{
    public KnigaNotFoundException() {
        super("Book's not found.");
    }
}

