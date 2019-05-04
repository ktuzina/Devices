package com.training.taskjava.datahandlers;

import com.training.taskjava.exceptions.NotFoundDeviceTypeException;
import com.training.taskjava.models.HouseDevices;

public interface DeviceDataHandler {

    HouseDevices readInfo() throws NotFoundDeviceTypeException;

    void writeInfo(HouseDevices devices);
}
