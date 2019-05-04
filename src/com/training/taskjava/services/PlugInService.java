package com.training.taskjava.services;

import com.training.taskjava.models.Device;
import com.training.taskjava.models.HouseDevices;

public class PlugInService {

    public static void plugInDevice(String name, HouseDevices houseDevices) {
        for (Device item : houseDevices.getDevices()) {
            if (item.getName().equals(name)) {
                item.setPlugIn(true);
            }
        }
    }
}
