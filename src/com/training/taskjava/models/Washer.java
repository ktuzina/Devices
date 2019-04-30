package com.training.taskjava.models;

public class Washer extends Device {

    private int capacity;
    private int spinSpeed;

    public Washer(String name, int power, int weight, boolean plugIn, int capacity, int spinSpeed) {
        super(name, power, weight, plugIn);
        this.capacity = capacity;
        this.spinSpeed = spinSpeed;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpinSpeed() {
        return spinSpeed;
    }

    public void setSpinSpeed(int spinSpeed) {
        this.spinSpeed = spinSpeed;
    }
}
