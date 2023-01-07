package org.aes.utillity;

import org.ahmeteminsaglik.ReadableFormat;

public class TimeCalculation {
    private long startTime, endTime, elapsedTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void printElapsedTime() {
//        System.out.println("Elapsed Time : " + ReadableStringFormat.getReadableValueIntToString((int) (elapsedTime / 1000))+" seconds");
        System.out.println("Elapsed Time : " + ReadableFormat.getStringValue((int) (elapsedTime)) + " miliSeconds");
    }

    public String getStringFormatElapsedTime() {
        return "Elapsed Time : " + ReadableFormat.getStringValue((int) (elapsedTime)) + " miliSeconds";
    }
}
