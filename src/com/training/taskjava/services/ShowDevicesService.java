package com.training.taskjava.services;

import com.training.taskjava.models.Device;
import com.training.taskjava.models.HouseDevices;

public class ShowDevicesService {

    public static void showHouseDevices(HouseDevices houseDevices){
        String str = "";
        System.out.println("List of devices:\n");
        for (Device item : houseDevices.getDevices()){
            str += item.toString();
        }
        System.out.println(str);
    }

    public static void showPluggedInDevices(HouseDevices houseDevices){
        String str = "";
        System.out.println("List of plugged in devices:\n");
        for (Device item : houseDevices.getDevices()){
            if (item.isPlugIn()){
                str += item.toString();
            }
        }
        System.out.println(str);
    }
}
