package com.training.taskjava.datahandlers;

import com.training.taskjava.exceptions.NotFoundDeviceTypeException;
import com.training.taskjava.models.*;

import java.io.*;

public class FileDeviceDataHandler implements DeviceDataHandler {

    private String path;

    public FileDeviceDataHandler(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public HouseDevices readInfo() throws NotFoundDeviceTypeException {

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

                switch (type) {
                    case 0:
                        fridge = new Fridge(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                                Boolean.parseBoolean(info[4]), Boolean.parseBoolean(info[5]), Integer.parseInt(info[6]));
                        devices.addDevice(fridge);
                        break;
                    case 1:
                        iron = new Iron(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                                Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6]));
                        devices.addDevice(iron);
                        break;
                    case 2:
                        washer = new Washer(info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                                Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6]));
                        devices.addDevice(washer);
                        break;
                    default:
                        throw new NotFoundDeviceTypeException(type);
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index exception: " + e);
        } catch (NumberFormatException e) {
            System.out.println("String doesn't contain integer: " + e);
        } catch (IOException e) {
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

    @Override
    public void writeInfo(HouseDevices devices) {

        File file = new File(getPath());
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(file));

            for (Device item : devices.getDevices()) {
                bw.write(item.toString());
            }

        } catch (IOException e) {
            System.out.println("Writing to file error");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Closing file error");
            }
        }

    }

}
