package com.phoenix.takeaway.exception;

public class AccountNotFoundException extends BaseException{
    public AccountNotFoundException(){}

    public AccountNotFoundException(String msg){
        super(msg);
    }
}
