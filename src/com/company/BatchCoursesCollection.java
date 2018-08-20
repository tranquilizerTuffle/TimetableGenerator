package com.company;

public class BatchCoursesCollection {

    private int NumberOfCourses;
    private BatchCourseDetails[] batchCourseDetails ;

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
        BatchCourseDetails mbatchCourseDetails = null;

        while(true){

            for ( mbatchCourseDetails : batchCourseDetails){

                if (mbatchCourseDetails.getPreference()==currentPreference){
                    break;
                }
            }

            


        }


    }

    public void DisplayTimeTable (){

    }
}
