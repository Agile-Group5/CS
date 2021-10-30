package com.se459.cleansweep;

public class DirtBin {

    private final int maxCapacity = 50;
    private int currentDirtLevel;

    public DirtBin() {
        currentDirtLevel = 0;
    }

    public int getDirtLevel() {
        return currentDirtLevel;
    }

    public void updateCDL() {
        currentDirtLevel++;
    }

    public boolean notFull() {
        return currentDirtLevel < maxCapacity;
    }

    public String CDLPercentToString() {
        double cdl = 100 * (currentDirtLevel / maxCapacity);
        return String.valueOf(cdl);
    }
}
