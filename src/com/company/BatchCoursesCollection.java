package com.company;

public class BatchCoursesCollection {

    private int NumberOfCourses;
    private BatchCourseDetails[] batchCourseDetails ;
    private TimeTable timeTable;

    public BatchCoursesCollection(int numberOfCourses, BatchCourseDetails[] batchCourseDetails) {
        NumberOfCourses = numberOfCourses;
        this.batchCourseDetails = batchCourseDetails;
    }

    public int getNumberOfCourses() {
        return NumberOfCourses;
    }

    public BatchCourseDetails[] getBatchCourseDetails() {
        return batchCourseDetails;
    }

    public void ComputeTimeTable(){

        int currentPreference = 1;
        int currentSlot = 1;

        while (true) {

            for (BatchCourseDetails mbatchCourseDetails : batchCourseDetails) {

                if ((mbatchCourseDetails.getPreference()) == currentPreference) {

                    int numberOfSlots = mbatchCourseDetails.getNumberOfSlots();
                    Slot[] slots = mbatchCourseDetails.getSlots();

                    String timePreferred = slots[currentSlot].getTimePreference();
                    String dayPreferred = slots[currentSlot].getDayPreference();
                    int duration = slots[currentSlot].getDuration();

                    String[] timePreferences = new String[7];

                    int i = 0, j = 0;

                    while (timePreferred != null) {
                        if (((i * 4) - 1) > timePreferred.lastIndexOf(timePreferred)) break;
                        timePreferences[i] = timePreferred.substring(i * 4, (i + 1) * 4);
                        i++;
                    }

                    String[][] day = null;
                    day[0] = timeTable.getMonday();
                    day[1] = timeTable.getMonday();
                    day[2] = timeTable.getMonday();
                    day[3] = timeTable.getMonday();
                    day[4] = timeTable.getMonday();
                    day[5] = timeTable.getMonday();


                    //day = timeTable.getMonday();
                    boolean slotAvailable = false;

                    if (timePreferred != null) {

                        for (i = 0; i < 6; i++) {                                                                                         //allDaysOfTheWeek

                            for (j = 0; j < 7; j++) {                                                                                    //allSlotsInADay


                                int p = 1;
                                while (p <= duration) {

                                    if (day[i][j + p - 1].isEmpty() && p == duration) {
                                        slotAvailable = true;
                                    }

                                }
                                if (slotAvailable) break;
                            }
                        }

                        if (slotAvailable) break;

                    }

                    else {

                    }


                }


            }

        }

    }

    public void DisplayTimeTable (){

    }
}
