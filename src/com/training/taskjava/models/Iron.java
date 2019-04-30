package com.training.taskjava.models;

public class Iron extends Device {

    private int steamOutput;
    private int waterCapacity;
// не используемый конструктор?
    public Iron(String name, int power, int weight, boolean plugIn) {
        super(name, power, weight, plugIn);
    }

    public Iron(String name, int power, int weight, boolean plugIn, int steamOutput, int waterCapacity) {
        super(name, power, weight, plugIn);
        this.steamOutput = steamOutput;
        this.waterCapacity = waterCapacity;
    }

    public int getSteamOutput() {
        return steamOutput;
    }

    public void setSteamOutput(int steamOutput) {
        this.steamOutput = steamOutput;
    }

    public int getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(int waterCapacity) {
        this.waterCapacity = waterCapacity;
    }
}
