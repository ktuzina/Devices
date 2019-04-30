package com.training.taskjava.services;

import com.training.taskjava.models.Fridge;
import com.training.taskjava.models.HouseDevices;
import com.training.taskjava.models.Iron;
import com.training.taskjava.models.Washer;

public class CreateDeviceDataService {

    public static HouseDevices addData(){

        HouseDevices devices = new HouseDevices();
        devices.addDevice(new Fridge("Fridge", 1000, 55, true, true, 5));
        devices.addDevice(new Iron("Iron", 1000, 55, false, 120, 300));
        devices.addDevice(new Washer("Washer", 1200, 40, false, 6, 1000));

        return devices;
    }
}
