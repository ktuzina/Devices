package com.training.taskjava.services;

import com.training.taskjava.datahandlers.FileDeviceDataHandler;
import com.training.taskjava.exceptions.NoPluggedInDevicesException;
import com.training.taskjava.models.Device;
import com.training.taskjava.models.HouseDevices;

public class ShowDevicesService {

    private static final String OUTPUT_DEVICE_DATA_FILE = "output_data.txt";

    public static void showHouseDevices(HouseDevices houseDevices) {
        String str = "";
        System.out.println("List of devices:\n");
        for (Device item : houseDevices.getDevices()) {
            str += item.toString();
        }
        System.out.println(str);
    }

    public static void showPluggedInDevices(HouseDevices houseDevices) throws NoPluggedInDevicesException {
        String str = "";
        System.out.println("List of plugged in devices:\n");
        for (Device item : houseDevices.getDevices()) {
            if (item.isPlugIn()) {
                str += item.toString();
            }
        }
        if (str.equals("")) {
            throw new NoPluggedInDevicesException();
        } else System.out.println(str);
    }

    public static void outputToFileHouseDevices(HouseDevices houseDevices) {
        FileDeviceDataHandler fileWriter = new FileDeviceDataHandler(OUTPUT_DEVICE_DATA_FILE);
        fileWriter.writeInfo(houseDevices);
    }
}
