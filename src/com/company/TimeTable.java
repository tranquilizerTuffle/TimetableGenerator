package com.company;

public class TimeTable {
    private  String[][] Week;


    public TimeTable() {
        Week = new String[6][7];
    }

    public String[][] getWeek() {
        return Week;
    }

    public void setWeek(String[][] week) {
        Week = week;
    }
}
