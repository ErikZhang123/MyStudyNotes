package com.Exception;

public class NoEnoughBalanceException extends RuntimeException{
    public NoEnoughBalanceException() {
        super("账户余额不足");
    }

    public NoEnoughBalanceException(String message) {
        super("账户余额不足");
    }
}
