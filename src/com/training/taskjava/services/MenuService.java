package com.training.taskjava.services;

import com.training.taskjava.comparators.WeightComparator;
import com.training.taskjava.exceptions.FindByPowerAndWeightException;
import com.training.taskjava.exceptions.NoPluggedInDevicesException;
import com.training.taskjava.models.HouseDevices;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuService {

    public static HouseDevices functionsToGetData() {
        boolean repeat = true;
        HouseDevices devices = new HouseDevices();

        while (repeat) {
            System.out.println("1. get data from txt file");
            System.out.println("2. get data from database");
            System.out.println("3. get data from xml file");

            int action = -1;
            Scanner sc = new Scanner(System.in);
            try {
                action = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not integer value is entered " + e);
            } catch (NoSuchElementException e) {
                System.out.println(e);
            }

            switch (action) {
                case 1:
                    devices = CreateDeviceDataService.addDataFromFile();
                    repeat = false;
                    break;
                case 2:
                    devices = CreateDeviceDataService.addDataFromDB();
                    repeat = false;
                    break;
                case 3:
                    devices = CreateDeviceDataService.addDataFromXML();
                    repeat = false;
                    break;
                default:
                    repeat = true;
                    break;
            }
        }
        return devices;
    }


    public static void availableFunctions(HouseDevices devices) {
        boolean repeat = true;

        while (repeat) {
            System.out.println("1. show house devices and count used power");
            System.out.println("2. sort");
            System.out.println("3. find");
            System.out.println("4. plug in device");
            System.out.println("0. exit");

            int action = -1;
            Scanner sc = new Scanner(System.in);
            try {
                action = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not integer value is entered " + e);
            } catch (NoSuchElementException e) {
                System.out.println(e);
            }

            switch (action) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    ShowDevicesService.showHouseDevices(devices);
                    System.out.println("Used capacity is ");
                    try {
                        System.out.println(CountPowerService.countUsedPower(devices));
                    } catch (NoPluggedInDevicesException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    Collections.sort(devices.getDevices(), new WeightComparator());
                    System.out.println("Sorted by weight ");
                    ShowDevicesService.showHouseDevices(devices);
                    ShowDevicesService.outputToFileHouseDevices(devices);
                    break;
                case 3:
                    int findPower = 0;
                    int findWeight = 0;

                    try {
                        System.out.println("Input power: ");
                        findPower = sc.nextInt();
                        System.out.println("Input weight: ");
                        findWeight = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Not integer value is entered " + e);
                        break;
                    } catch (NoSuchElementException e) {
                        System.out.println(e);
                        break;
                    }

                    try {
                        System.out.println(SearchDeviceService.findDeviceByPowerAndWeight(findPower, findWeight, devices));
                    } catch (FindByPowerAndWeightException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Input device name: ");
                    String deviceName = new Scanner(System.in).next();
                    System.out.println(deviceName);
                    PlugInService.plugInDevice(deviceName, devices);
                    try {
                        ShowDevicesService.showPluggedInDevices(devices);
                    } catch (NoPluggedInDevicesException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
