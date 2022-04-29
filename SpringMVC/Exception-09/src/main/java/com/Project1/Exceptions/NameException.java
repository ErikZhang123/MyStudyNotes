package com.Project1.Exceptions;

//当用户的姓名有异常的时候抛出
public class NameException extends UserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
