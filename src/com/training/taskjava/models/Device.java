package com.training.taskjava.models;

public abstract class Device {

    private String name;
    private int power;
    private int weight;
    private boolean plugIn;

    public Device(String name, int power, int weight, boolean plugIn) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.plugIn = plugIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isPlugIn() {
        return plugIn;
    }

    public void setPlugIn(boolean plugIn) {
        this.plugIn = plugIn;
    }

    @Override
    public String toString() {
        return "Device: " + this.name + ", power: " + this.power + ", weight: " + this.weight + "\n";
    }

    public void plugInDevice() {
        this.plugIn = true;
    }
}
