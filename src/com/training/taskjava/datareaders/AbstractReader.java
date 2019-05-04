package com.training.taskjava.datareaders;

import com.training.taskjava.exceptions.NotFoundDeviceTypeException;
import com.training.taskjava.models.HouseDevices;

public abstract class AbstractReader {

    public abstract HouseDevices readInfo() throws NotFoundDeviceTypeException;

}
