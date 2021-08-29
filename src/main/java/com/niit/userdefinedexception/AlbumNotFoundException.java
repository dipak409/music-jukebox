package com.niit.userdefinedexception;

public class AlbumNotFoundException extends Exception{
    public AlbumNotFoundException(String message)
    {
        super(message);
    }
}
