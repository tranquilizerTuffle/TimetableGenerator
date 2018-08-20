package com.company;

public class AllotedSlot {
    private String Day;
    private String Time;

    public AllotedSlot(String day, String time) {

        Day = day;
        Time = time;
    }

    public String getDay() {
        return Day;
    }

    public String getTime() {
        return Time;
    }
}
