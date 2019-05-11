package com.training.taskjava.main;

import com.training.taskjava.models.HouseDevices;
import com.training.taskjava.services.MenuService;

public class Main {

    public static void main(String[] args) {

        HouseDevices devices = MenuService.functionsToGetData();
        MenuService.availableFunctions(devices);

    }
}
