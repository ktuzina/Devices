package com.training.taskjava.exceptions;

public class NoPluggedInDevicesException extends Exception{

    public String getMessage(){
        return "[NoPluggedInDevicesException]: There are no plugged in devices";
    }
}
