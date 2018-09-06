package com.company;

import java.util.ArrayList;

public class BatchCourseDetails extends Course {

    private String FacultyName;
    private int Preference;
    private int NumberOfSlots;
    private ArrayList<Slot> slots;
    private ArrayList<AllotedSlot> allotedSlots;

    public BatchCourseDetails(String courseName, String courseCode, String facultyName, int preference, int numberOfSlots) {
        super(courseName, courseCode);
        FacultyName = facultyName;
        Preference = preference;
        NumberOfSlots = numberOfSlots;
    }

    public  String getCourseCode(){ return  super.getCourseCode();}
    public String getFacultyName() {
        return FacultyName;
    }

    public int getPreference() {
        return Preference;
    }

    public int getNumberOfSlots() {
        return NumberOfSlots;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }

    public void setAllotedSlots(ArrayList<AllotedSlot> allotedSlots) {
        this.allotedSlots = allotedSlots;
    }
}
