package com.training.taskjava.models;

// как мне кажется лучше этот клас сделать абстрактным
public class Device {
// почему эти поля протектед?
    protected String name;
    protected int power;
    protected int weight;
    protected boolean plugIn;

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

//    тебе не нужно отдельный метод для этого, проще оверрадить toString() с необходимым описанием
    public String getInfo(){
        return "Device: " + this.name + ", power: " + this.power + ", weight: " + this.weight + "\n";
        //return "Power: " + this.power + ", weight: " + this.weight + ", colour:" + this.colour + "plugIn: " + this.plugIn;
    }

    public void plugInDevice(){
        this.plugIn = true;
    }
}
