package com.training.taskjava.main;

import com.training.taskjava.models.*;
import com.training.taskjava.services.*;

public class Main {

    public static void main(String[] args) {

        HouseDevices devices = CreateDeviceDataService.addData();
        MenuService.availableFunctions(devices);

    }
}
