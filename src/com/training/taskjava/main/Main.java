package com.training.taskjava.main;

import com.training.taskjava.comparators.PriceComparator;
import com.training.taskjava.models.*;

import java.util.Collections;
import java.util.Scanner;
// так же я бы разбил этот класс на несколько сервисных. Мейн класс обычно используют как точку входа в программу,
// в которой нет функционального входа, только вызовы конкретных исполняемых классов
public class Main {

    public static void main(String[] args) {

        boolean repeat = true;

        HouseDevices devices = new HouseDevices();
        devices.addDevice(new Fridge("Fridge", 1000, 55, true, true, 5));
        devices.addDevice(new Iron("Iron", 1500, 4, false, 120, 300));
        devices.addDevice(new Washer("Washer", 1200, 40, false, 6, 1000));



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
                    System.out.println(devices.showHouseDevices());
                    System.out.println("Used capacity is ");
                    System.out.println(devices.countUsedPower());
                    break;
                case 2:
//                    сортировка по весу с PriceComparator :)
                    Collections.sort(devices.getDevices(), new PriceComparator());
                    System.out.println("Sorted by weight ");
                    System.out.println(devices.showHouseDevices());
                    break;
                case 3:
                    System.out.println("Input power: ");
                    int findPower = new Scanner(System.in).nextInt();
                    System.out.println("Input weight: ");
                    int findWeight = new Scanner(System.in).nextInt();
                    System.out.println(devices.findDevice(findPower, findWeight));
                    break;
                case 4:
                    System.out.println("Input device name: ");
                    String deviceName = new Scanner(System.in).next();
                    System.out.println(deviceName);
                    devices.plugInDevice(deviceName);
                    System.out.println(devices.showPluggedInDevices());
                    break;
                default:
                    break;
            }
        }

    }
}
