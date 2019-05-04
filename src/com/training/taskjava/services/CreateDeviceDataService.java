package com.training.taskjava.services;

import com.training.taskjava.datahandlers.FileDeviceDataHandler;
import com.training.taskjava.exceptions.NotFoundDeviceTypeException;
import com.training.taskjava.models.Fridge;
import com.training.taskjava.models.HouseDevices;
import com.training.taskjava.models.Iron;
import com.training.taskjava.models.Washer;

public class CreateDeviceDataService {

    private static final String DEVICE_DATA_FILE = "data.txt";

    public static HouseDevices addData() {

        HouseDevices devices = new HouseDevices();
        devices.addDevice(new Fridge("Fridge", 1000, 55, true, true, 5));
        devices.addDevice(new Iron("Iron", 1000, 55, false, 120, 300));
        devices.addDevice(new Washer("Washer", 1200, 40, false, 6, 1000));

        return devices;
    }

    public static HouseDevices addDataFromFile() {

        HouseDevices devices = new HouseDevices();
        FileDeviceDataHandler fileReader = new FileDeviceDataHandler(DEVICE_DATA_FILE);
        try {
            devices = fileReader.readInfo();
        } catch (NotFoundDeviceTypeException e) {
            System.out.println(e.getMessage());
        }
        return devices;
    }
}
