package com.training.taskjava.parser;

import com.training.taskjava.models.Fridge;
import com.training.taskjava.models.HouseDevices;
import com.training.taskjava.models.Iron;
import com.training.taskjava.models.Washer;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class DevicesSAXParser extends DefaultHandler {

    private Fridge fridge;
    private Iron iron;
    private Washer washer;
    private HouseDevices devices = new HouseDevices();
    private StringBuilder thisElement;
    private Map<String, String> fields = new HashMap<>();

    @Override
    public void startDocument() {
        System.out.println("Start parse XML document with Devices Info");
    }

    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) {
        thisElement = new StringBuilder();
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {

        switch (qName) {
            case "fridge":
                String name = fields.get("name");
                int power = Integer.parseInt(fields.get("power"));
                int weight = Integer.parseInt(fields.get("weight"));
                boolean plugIn = Boolean.parseBoolean(fields.get("plugIn"));
                boolean noFrost = Boolean.parseBoolean(fields.get("noFrost"));
                int shelfCount = Integer.parseInt(fields.get("shelfCount"));
                fridge = new Fridge(name, power, weight, plugIn, noFrost, shelfCount);
                devices.addDevice(fridge);
                break;
            case "iron":
                name = fields.get("name");
                power = Integer.parseInt(fields.get("power"));
                weight = Integer.parseInt(fields.get("weight"));
                plugIn = Boolean.parseBoolean(fields.get("plugIn"));
                int steamOutput = Integer.parseInt(fields.get("steamOutput"));
                int waterCapacity = Integer.parseInt(fields.get("waterCapacity"));
                iron = new Iron(name, power, weight, plugIn, steamOutput, waterCapacity);
                devices.addDevice(iron);
                break;
            case "washer":
                name = fields.get("name");
                power = Integer.parseInt(fields.get("power"));
                weight = Integer.parseInt(fields.get("weight"));
                plugIn = Boolean.parseBoolean(fields.get("plugIn"));
                int capacity = Integer.parseInt(fields.get("capacity"));
                int spinSpeed = Integer.parseInt(fields.get("spinSpeed"));
                washer = new Washer(name, power, weight, plugIn, capacity, spinSpeed);
                devices.addDevice(washer);
                break;
            default:
                String elementVal = thisElement.toString();
                fields.put(qName, elementVal);
        }

        thisElement = new StringBuilder();
        ;
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML document with Devices Info");

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        thisElement.append(ch, start, length);
    }

    public HouseDevices getHouseDevices() {
        return devices;
    }

}
