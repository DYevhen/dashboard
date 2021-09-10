package com.exadel.core.exceptions;

public class DuplicateNewsException extends Exception{

    public DuplicateNewsException() {
        super("That news already created");
    }
}
