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

}
