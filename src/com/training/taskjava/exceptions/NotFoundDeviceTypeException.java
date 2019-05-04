package com.training.taskjava.exceptions;

public class NotFoundDeviceTypeException extends Exception{

    private int type;

    public NotFoundDeviceTypeException(int type) {
        this.type = type;
    }

    public String getMessage(){
        return "[NotFoundDeviceTypeException]: Unexpected type. Record with type=" + this.type + " can't be added";
    }
}
