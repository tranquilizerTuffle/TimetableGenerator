package com.company;

import java.util.ArrayList;

public class Slot {
    private int Duration;
    private ArrayList<Integer> DayPreference;
    private ArrayList<String> TimePreference;

    public Slot(int duration, ArrayList<Integer> dayPreference, ArrayList<String> timePreference) {
        Duration = duration;
        DayPreference = dayPreference;
        TimePreference = timePreference;
    }

    public int getDuration() {
        return Duration;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "Duration=" + Duration +
                ", DayPreference=" + DayPreference +
                ", TimePreference=" + TimePreference +
                '}';
    }

    public ArrayList<Integer> getDayPreference() {
        return DayPreference;
    }

    public ArrayList<String> getTimePreference() {
        return TimePreference;
    }
}
