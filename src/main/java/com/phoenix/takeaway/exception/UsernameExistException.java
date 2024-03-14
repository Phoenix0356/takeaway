package com.phoenix.takeaway.exception;

import java.sql.SQLException;

public class UsernameExistException extends SQLException {
    public UsernameExistException(){}
    public UsernameExistException(String msg){
        super(msg);
    }
}
