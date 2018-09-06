package com.company;


import java.util.ArrayList;

public class BatchCoursesCollection {

    private int NumberOfCourses;
    private ArrayList<BatchCourseDetails> batchCourseDetails ;
    private TimeTable timeTable;

    public BatchCoursesCollection(int numberOfCourses, ArrayList<BatchCourseDetails> batchCourseDetails) {
        NumberOfCourses = numberOfCourses;
        this.batchCourseDetails = batchCourseDetails;
    }

    public int getNumberOfCourses() {
        return NumberOfCourses;
    }

    public ArrayList<BatchCourseDetails> getBatchCourseDetails() {
        return batchCourseDetails;
    }

    public void ComputeTimeTable() {

        int currentPreference = 1;
        int currentSlot = 1;

        while (true) {

            for (BatchCourseDetails mbatchCourseDetails : batchCourseDetails) {

                if ((mbatchCourseDetails.getPreference()) == currentPreference) {

                    int numberOfSlots = mbatchCourseDetails.getNumberOfSlots();
                    ArrayList<Slot> slots = mbatchCourseDetails.getSlots();

                    ArrayList<String> timePreferred = slots.get(currentSlot).getTimePreference();
                    ArrayList<Integer> dayPreferred = slots.get(currentSlot).getDayPreference();
                    int duration = slots.get(currentSlot).getDuration();


                    String[][] day = timeTable.getWeek();

                    boolean slotAvailable = false;

                    //Start of 1st/3rd attempt

                    for (String time : timePreferred){

                        int timeInt = SlotToInt(time);

                        for( Integer integer : dayPreferred){

                                if (day[integer-1][timeInt-1].isEmpty()){
                                    slotAvailable=true;
                                }
                        }
                        //End of 1st Attempt

                        //Start of 2nd/4th attempt

                            for( Integer integer : dayPreferred){

                                for (int i = 0;i<7;i++){

                                    if((integer-1) == i)continue;
                                    if (day[i][timeInt-1].isEmpty()){
                                        slotAvailable=true;
                                    }
                                }
                            }

                        //end of 2nd attempt
                    }
                    //Attempt 4 best day
                    for( Integer integer : dayPreferred){

                        for (int i = 0;i<7;i++){

                            if (day[integer-1][i].isEmpty()){
                                slotAvailable=true;
                            }
                        }
                    }

                }
            }
        }
    }

    private int SlotToInt(String time){
        int timeInt=0;
        if (time.equals("0900")) timeInt=1;
        if (time.equals("1000")) timeInt=2;
        if (time.equals("1115")) timeInt=3;
        if (time.equals("1215")) timeInt=4;
        if (time.equals("0300")) timeInt=5;
        if (time.equals("0400")) timeInt=6;
        if (time.equals("0500")) timeInt=7;
        return timeInt;
    }

    public void DisplayTimeTable (){

    }
}
