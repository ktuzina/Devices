package com.training.taskjava.datawriters;

import com.training.taskjava.models.Device;
import com.training.taskjava.models.HouseDevices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileWriter extends AbstractWriter{

    private String path;

    public TxtFileWriter(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void writeInfo(HouseDevices devices){

        File file = new File(getPath());
        BufferedWriter bw = null;

        try{
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
