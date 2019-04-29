package com.training.taskjava.models;

public class Fridge extends Device {

    private boolean noFrost;
    private int shelfCount;

    public Fridge(String name, int power, int weight, boolean plugIn) {
        super(name, power, weight, plugIn);
    }

    public Fridge(String name, int power, int weight, boolean plugIn, boolean noFrost, int shelfCount) {
        super(name, power, weight, plugIn);
        this.noFrost = noFrost;
        this.shelfCount = shelfCount;
    }

    public boolean isNoFrost() {
        return noFrost;
    }

    public void setNoFrost(boolean noFrost) {
        this.noFrost = noFrost;
    }

    public int getShelfCount() {
        return shelfCount;
    }

    public void setShelfCount(int shelfCount) {
        this.shelfCount = shelfCount;
    }

}
