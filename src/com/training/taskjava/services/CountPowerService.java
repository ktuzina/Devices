package com.training.taskjava.services;

import com.training.taskjava.exceptions.NoPluggedInDevicesException;
import com.training.taskjava.models.Device;
import com.training.taskjava.models.HouseDevices;

public class CountPowerService {

    public static int countUsedPower(HouseDevices houseDevices) throws NoPluggedInDevicesException{
        int power = 0;

        for (Device item : houseDevices.getDevices()){
            if (item.isPlugIn()){
                power += item.getPower();
            }
        }
        if (power != 0) {
            return power;
        } else throw new NoPluggedInDevicesException();
    }
}
