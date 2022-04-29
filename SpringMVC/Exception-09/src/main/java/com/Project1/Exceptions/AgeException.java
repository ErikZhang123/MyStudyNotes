package com.Project1.Exceptions;
//当年龄有异常
public class AgeException extends UserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
