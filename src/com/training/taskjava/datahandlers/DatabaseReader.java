package com.training.taskjava.datahandlers;

import com.training.taskjava.models.Fridge;
import com.training.taskjava.models.HouseDevices;
import com.training.taskjava.models.Iron;
import com.training.taskjava.models.Washer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseReader implements DeviceDataHandler {

    private Connection connection;

    public DatabaseReader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public HouseDevices readInfo() {
        PreparedStatement prState = null;
        ResultSet rs = null;

        HouseDevices devices = new HouseDevices();
        Fridge fridge = null;
        Iron iron = null;
        Washer washer = null;

        try {
            prState = getConnection().prepareStatement("SELECT * from fridges;");
            rs = prState.executeQuery();
            while (rs.next()) {
                fridge = new Fridge(rs.getString("name"), rs.getInt("power"), rs.getInt("weight"), rs.getBoolean("plugIn"),
                        rs.getBoolean("noFrost"), rs.getInt("shelfCount"));
                devices.addDevice(fridge);
            }

            prState = getConnection().prepareStatement("SELECT * from irons;");
            rs = prState.executeQuery();
            while (rs.next()) {
                iron = new Iron(rs.getString("name"), rs.getInt("power"), rs.getInt("weight"), rs.getBoolean("plugIn"),
                        rs.getInt("steamOutput"), rs.getInt("waterCapacity"));
                devices.addDevice(iron);
            }

            prState = getConnection().prepareStatement("SELECT * from washers;");
            rs = prState.executeQuery();
            while (rs.next()) {
                washer = new Washer(rs.getString("name"), rs.getInt("power"), rs.getInt("weight"), rs.getBoolean("plugIn"),
                        rs.getInt("capacity"), rs.getInt("spinSpeed"));
                devices.addDevice(washer);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
            }
            try {
                if (prState != null)
                    prState.close();
            } catch (SQLException e) {
            }
        }
        return devices;
    }

    @Override
    public void writeInfo(HouseDevices devices) {

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
