package com.company;

public class BatchCourseDetails extends Course {

    private String FacultyName;
    private int Preference;
    private int NumberOfSlots;
    private Slot[] slots;
    private AllotedSlot[] allotedSlots;

    public BatchCourseDetails(String courseName, String courseCode, String facultyName, int preference, int numberOfSlots) {
        super(courseName, courseCode);
        FacultyName = facultyName;
        Preference = preference;
        NumberOfSlots = numberOfSlots;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public int getPreference() {
        return Preference;
    }

    public int getNumberOfSlots() {
        return NumberOfSlots;
    }

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    public void setAllotedSlots(AllotedSlot[] allotedSlots) {
        this.allotedSlots = allotedSlots;
    }
}
