package com.training.taskjava.datareaders;

import com.training.taskjava.exceptions.NotFoundDeviceTypeException;
import com.training.taskjava.models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TxtFileReader extends AbstractReader{

    private String path;

    public TxtFileReader(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public HouseDevices readInfo()throws NotFoundDeviceTypeException{

        HouseDevices devices = new HouseDevices();
        File file = new File(getPath());
        BufferedReader br = null;
        String strLine = "";
        Fridge fridge = null;
        Iron iron = null;
        Washer washer = null;

        try {
            br = new BufferedReader(new FileReader(file));

            while ((strLine = br.readLine()) != null) {
                String[] info = strLine.split(":");
                int type = Integer.parseInt(info[0]);
                if (type == 0) {
                    fridge = new Fridge(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            Boolean.parseBoolean(info[4]), Boolean.parseBoolean(info[5]), Integer.parseInt(info[6]));
                    devices.addDevice(fridge);
                } else if (type == 1) {
                    iron = new Iron(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6]));
                    devices.addDevice(iron);
                } else if (type == 2) {
                    washer = new Washer(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6]));
                    devices.addDevice(washer);
                } else throw new NotFoundDeviceTypeException(type);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index exception: " + e);
        } catch (NumberFormatException e){
            System.out.println("String doesn't contain integer: " + e);
        } catch (IOException e){
            System.out.println("Reading file error");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Closing file error");
            }
        }

        return devices;
    }
}
