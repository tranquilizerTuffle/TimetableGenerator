package com.company;

public class Slot {
    private int Duration;
    private String DayPreference;
    private String TimePreference;

    public Slot(int duration, String dayPreference, String timePreference) {
        Duration = duration;
        DayPreference = dayPreference;
        TimePreference = timePreference;
    }

    public int getDuration() {
        return Duration;
    }

    public String getDayPreference() {
        return DayPreference;
    }

    public String getTimePreference() {
        return TimePreference;
    }
}
