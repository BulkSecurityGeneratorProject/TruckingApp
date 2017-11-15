package com.itechart.dao.exception;

public class ClientDaoException extends Exception{

    public ClientDaoException(){}

    public ClientDaoException(String message, Throwable exception){
        super(message, exception);
    }

    public ClientDaoException(String message){
        super(message);
    }

    public ClientDaoException(Throwable exception){
        super(exception);
    }
}
