package com.company;

public class TimeTable {
    private String[] Monday;
    private String[] Tuesday;
    private String[] Wednesday;
    private String[] Thursday;
    private String[] Friday;
    private String[] Saturday;

    public TimeTable() {
        Monday = new String[7];
        Tuesday = new  String[7];
        Wednesday = new String[7];
        Thursday = new String[7];
        Friday = new String[7];
        Saturday = new String[7];
    }

    public String[] getMonday() {
        return Monday;
    }

    public void setMonday(String[] monday) {
        Monday = monday;
    }

    public String[] getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String[] tuesday) {
        Tuesday = tuesday;
    }

    public String[] getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String[] wednesday) {
        Wednesday = wednesday;
    }

    public String[] getThursday() {
        return Thursday;
    }

    public void setThursday(String[] thursday) {
        Thursday = thursday;
    }

    public String[] getFriday() {
        return Friday;
    }

    public void setFriday(String[] friday) {
        Friday = friday;
    }

    public String[] getSaturday() {
        return Saturday;
    }

    public void setSaturday(String[] saturday) {
        Saturday = saturday;
    }
}
