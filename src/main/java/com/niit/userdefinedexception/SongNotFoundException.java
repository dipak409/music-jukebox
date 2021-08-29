package com.niit.userdefinedexception;

public class SongNotFoundException extends Exception {
    public SongNotFoundException(String message)
    {
        super(message);
    }

}
