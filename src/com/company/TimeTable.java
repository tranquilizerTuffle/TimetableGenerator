package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeTable {
    private  String[][] Week;
    private int[][] weekSlot;
    private ArrayList<String> saturday;
    private int[] WorkingHours ;


    public int[] getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(int[] workingHours) {
        WorkingHours = workingHours;
    }

    public ArrayList<String> getSaturday() {
        return saturday;
    }

    public void addSaturday(String sat) {
        saturday.add(sat);
    }

    public int[][] getWeekSlot() {
        return weekSlot;
    }

    public void setWeekSlot(int[][] weekSlot) {
        this.weekSlot = weekSlot;
    }

    public TimeTable() {
        Week = new String[5][7];
        WorkingHours = new int[5];
        saturday = new ArrayList<String>();
        weekSlot = new  int[5][7];
    }

    public String[][] getWeek() {
        return Week;
    }

    public void setWeek(String[][] week) {
        Week = week;
    }
}
