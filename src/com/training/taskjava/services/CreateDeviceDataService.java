package com.training.taskjava.services;

import com.training.taskjava.datahandlers.DatabaseReader;
import com.training.taskjava.datahandlers.FileDeviceDataHandler;
import com.training.taskjava.datahandlers.XMLFileReader;
import com.training.taskjava.exceptions.NotFoundDeviceTypeException;
import com.training.taskjava.models.Fridge;
import com.training.taskjava.models.HouseDevices;
import com.training.taskjava.models.Iron;
import com.training.taskjava.models.Washer;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateDeviceDataService {

    private static final String DEVICE_DATA_FILE = "data.txt";
    private static final String DATABASE_PROPERTIES = "database.prop";
    private static final String DEVICE_INFO_XML = "devices.xml";

    static Properties pr = new Properties();

    static {
        try {
            FileInputStream inp = new FileInputStream(DATABASE_PROPERTIES);
            pr.load(inp);
            inp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String databaseURL = pr.getProperty("dbURL");
    static String user = pr.getProperty("user");
    static String password = pr.getProperty("password");
    //static String driverName = pr.getProperty("driver");

    public static HouseDevices addData() {

        HouseDevices devices = new HouseDevices();
        devices.addDevice(new Fridge("Fridge", 1000, 55, true, true, 5));
        devices.addDevice(new Iron("Iron", 1000, 55, false, 120, 300));
        devices.addDevice(new Washer("Washer", 1200, 40, false, 6, 1000));

        return devices;
    }

    public static HouseDevices addDataFromFile() {

        HouseDevices devices = new HouseDevices();
        FileDeviceDataHandler fileReader = new FileDeviceDataHandler(DEVICE_DATA_FILE);
        try {
            devices = fileReader.readInfo();
        } catch (NotFoundDeviceTypeException e) {
            System.out.println(e.getMessage());
        }
        return devices;
    }

    public static HouseDevices addDataFromDB() {
        HouseDevices devices = new HouseDevices();

        Connection c = null;
        try {
            c = DriverManager.getConnection(databaseURL, user, password);
            System.out.println("Connect");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }

        DatabaseReader dbReader = new DatabaseReader(c);
        try {
            devices = dbReader.readInfo();
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }

        try {
            if (c != null)
                c.close();
        } catch (SQLException e) {
        }


        return devices;
    }

    public static HouseDevices addDataFromXML() {
        HouseDevices devices = new HouseDevices();

        XMLFileReader xmlReader = new XMLFileReader(DEVICE_INFO_XML);
        try {
            devices = xmlReader.readInfo();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return devices;
    }
}
