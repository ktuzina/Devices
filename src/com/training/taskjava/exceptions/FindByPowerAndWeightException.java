package com.training.taskjava.exceptions;

public class FindByPowerAndWeightException extends Exception{

    private int power;
    private int weight;

    public FindByPowerAndWeightException(int power, int weight) {
        this.power = power;
        this.weight = weight;
    }

    public String getMessage(){
        return "[FindByPowerAndWeightException]: There are not records with power=" + this.power + " and weight=" + this.weight;
    }
}
