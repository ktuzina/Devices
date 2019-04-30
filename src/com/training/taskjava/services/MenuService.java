package com.training.taskjava.services;

import com.training.taskjava.comparators.WeightComparator;
import com.training.taskjava.models.HouseDevices;

import java.util.Collections;
import java.util.Scanner;

public class MenuService {

    public static void availableFunctions(HouseDevices devices){
        boolean repeat = true;

        while (repeat){
            System.out.println("1. show house devices and count used power");
            System.out.println("2. sort");
            System.out.println("3. find");
            System.out.println("4. plug in device");
            System.out.println("0. exit");

            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();

            switch (action){
                case 0:
                    repeat = false;
                    break;
                case 1:
                    ShowDevicesService.showHouseDevices(devices);
                    System.out.println("Used capacity is ");
                    System.out.println(CountPowerService.countUsedPower(devices));
                    break;
                case 2:
                    Collections.sort(devices.getDevices(), new WeightComparator());
                    System.out.println("Sorted by weight ");
                    ShowDevicesService.showHouseDevices(devices);
                    break;
                case 3:
                    System.out.println("Input power: ");
                    int findPower = new Scanner(System.in).nextInt();
                    System.out.println("Input weight: ");
                    int findWeight = new Scanner(System.in).nextInt();
                    System.out.println(SearchDeviceService.findDeviceByPowerAndWeight(findPower, findWeight, devices));
                    break;
                case 4:
                    System.out.println("Input device name: ");
                    String deviceName = new Scanner(System.in).next();
                    System.out.println(deviceName);
                    PlugInService.plugInDevice(deviceName, devices);
                    ShowDevicesService.showPluggedInDevices(devices);
                    break;
                default:
                    break;
            }
        }
    }

}
