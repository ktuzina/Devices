package com.training.taskjava.models;

import java.util.ArrayList;
import java.util.List;

// честно говоря было бы лучше если бы ты разбила этот класс на несколько сервисных классов
//Принцип единственной ответственности (The Single Responsibility Principle)
//Каждый класс выполняет лишь одну задачу.
public class HouseDevices {

    private List<Device> devices;

    public HouseDevices(){
        this.devices = new ArrayList<>();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device){
        devices.add(device);
    }

//    хм.. все методы называются показать(show) но они ничего не показывают, а только возврощают строку

    public String showHouseDevices(){
        String str = "";
        System.out.println("List of devices:\n");
        for (Device item : devices){
            str += item.getInfo();
        }
        return str;
    }

    public String showPluggedInDevices(){
        String str = "";
        System.out.println("List of plugged in devices:\n");
        for (Device item : devices){
//            пожалуйста используй геттер методы
            if (item.plugIn){
                str += item.getInfo();
            }
        }
        return str;
    }

    public int countUsedPower(){
        int power = 0;

        for (Device item : devices){
            //            пожалуйста используй геттер методы
            if (item.plugIn){
                power += item.power;
            }
        }
        return power;
    }
// а что ессли несколько девайсов будут иметь такие же аттрибуты для поиска?
    public String findDevice(int power, int weight){
        for (Device item: devices){
            if (item.getPower() == power && item.getWeight() == weight){
                return item.getInfo();
            }
        }
        return "No such device in the house";
    }

    public void plugInDevice(String name){
        for (Device item : devices){
            //            пожалуйста используй геттер методы
            if (item.name.equals(name)){
                item.plugIn = true;
            }
        }
    }


}
