package com.itechart.dao.exception;

public class WarehouseDaoException extends Exception{

    public WarehouseDaoException(){}

    public WarehouseDaoException(String message, Throwable exception){
        super(message, exception);
    }

    public WarehouseDaoException(String message){
        super(message);
    }

    public WarehouseDaoException(Throwable exception){
        super(exception);
    }
}
