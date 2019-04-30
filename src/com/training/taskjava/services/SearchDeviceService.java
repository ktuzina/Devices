package com.training.taskjava.services;

import com.training.taskjava.models.Device;
import com.training.taskjava.models.HouseDevices;

public class SearchDeviceService {

    public static String findDeviceByPowerAndWeight(int power, int weight, HouseDevices houseDevices){
        String str = "";

        for (Device item: houseDevices.getDevices()){
            if (item.getPower() == power && item.getWeight() == weight){
                str += item.toString();
            }
        }
        if (str.equals("")){
            return "No such device in the house";
        } else{
            return str;
        }
    }
}
