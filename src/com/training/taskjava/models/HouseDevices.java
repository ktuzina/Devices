package com.training.taskjava.models;

import java.util.ArrayList;
import java.util.List;

public class HouseDevices {

    private List<Device> devices;

    public HouseDevices(){
        this.devices = new ArrayList<>();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device){
        devices.add(device);
    }

    public String showHouseDevices(){
        String str = "";
        System.out.println("List of devices:\n");
        for (Device item : devices){
            str += item.getInfo();
        }
        return str;
    }

    public int countUsedPower(){
        int power = 0;

        for (Device item : devices){
            if (item.plugIn == true){
                power += item.power;
            }
        }
        return power;
    }

    public String findDevice(int power, int weight){
        for (Device item: devices){
            if (item.getPower() == power && item.getWeight() == weight){
                return item.getInfo();
            }
        }
        return "No such device in the house";
    }
}
