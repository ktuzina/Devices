package com.training.taskjava.datahandlers;

import com.training.taskjava.models.HouseDevices;
import com.training.taskjava.parser.DevicesSAXParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLFileReader implements DeviceDataHandler {

    private String path;

    public XMLFileReader(String path) {
        this.path = path;
    }

    @Override
    public HouseDevices readInfo() {
        HouseDevices devices = new HouseDevices();
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        SAXParser sp;
        DevicesSAXParser handler = null;
        try {
            sp = spfac.newSAXParser();
            handler = new DevicesSAXParser();
            sp.parse(new File(path), handler);
            devices = handler.getHouseDevices();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Parsing fails: " + e.getMessage());
        }


        return devices;
    }

    @Override
    public void writeInfo(HouseDevices devices) {

    }
}
