package com.training.taskjava.services;

import com.training.taskjava.models.Device;
import com.training.taskjava.models.HouseDevices;

public class CountPowerService {

    public static int countUsedPower(HouseDevices houseDevices){
        int power = 0;

        for (Device item : houseDevices.getDevices()){
            if (item.isPlugIn()){
                power += item.getPower();
            }
        }
        return power;
    }
}
