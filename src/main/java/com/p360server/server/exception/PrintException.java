package com.p360server.server.exception;

public class PrintException extends Exception{
    public PrintException(String str) {
        super(str);
        System.out.print(str);
    }
}
