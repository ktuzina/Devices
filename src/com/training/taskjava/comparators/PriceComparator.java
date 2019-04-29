package com.training.taskjava.comparators;

import com.training.taskjava.models.Device;

import java.util.Comparator;

import static java.lang.Math.ceil;

public class PriceComparator implements Comparator<Device> {
    @Override
    public int compare(Device o1, Device o2) {
        return (int) Math.ceil(o1.getWeight() - o2.getWeight());
    }
}
