package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
           int testCases;
           Scanner scanner = null;

           testCases = scanner.nextInt();

           for(int i = 0 ; i< testCases ; i++){

               int numberOfCourses = scanner.nextInt();
               BatchCoursesCollection batchCoursesCollection = null;
               BatchCourseDetails[] batchCourseDetails = new BatchCourseDetails[numberOfCourses];

               for (int j = 0 ; j< numberOfCourses ; j++){

                   String courseName = scanner.next();
                   String courseCode = scanner.next();
                   String facultyName = scanner.next();
                   int preference = scanner.nextInt();
                   int numberOfSlots = scanner.nextInt();

                   batchCourseDetails[j]= new BatchCourseDetails(courseName, courseCode, facultyName,
                           preference, numberOfSlots);

                   Slot[] slots = new Slot[numberOfSlots];

                   for(int k=0 ;k< numberOfSlots ; k++){

                       int duration = scanner.nextInt() ;
                       String dayPreference = scanner.next();
                       String timePreference = scanner.next();

                       slots[k] = new Slot(duration, dayPreference, timePreference);
                   }

                   batchCourseDetails[j].setSlots(slots);
               }

               batchCoursesCollection = new BatchCoursesCollection(numberOfCourses,batchCourseDetails);

               batchCoursesCollection.ComputeTimeTable();
               batchCoursesCollection.DisplayTimeTable();

           }

      }
}
