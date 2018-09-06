package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class Main {

    public static void main(String[] args) {
           int testCases;
           Scanner scanner = new Scanner(System.in);

           testCases = scanner.nextInt();

           for(int i = 0 ; i< testCases ; i++){

               int numberOfCourses = scanner.nextInt();
               BatchCoursesCollection batchCoursesCollection = null;
               ArrayList<BatchCourseDetails> batchCourseDetails = new
                       ArrayList<BatchCourseDetails>();

               for (int j = 0 ; j< numberOfCourses ; j++){
                   String courseCode = scanner.next();
                   String courseName = scanner.next();
                   String facultyName = scanner.next();
                   int preference = scanner.nextInt();
                   int numberOfSlots = scanner.nextInt();
                   batchCourseDetails.add(j,new BatchCourseDetails(courseName, courseCode, facultyName,
                           preference, numberOfSlots) );

                   ArrayList<Slot> slots = new ArrayList<Slot>();


                   for(int k=0 ;k< numberOfSlots ; k++){

                       int duration = scanner.nextInt() ;
                       String dayPreference = scanner.next();
                       String timePreferred = scanner.next();
                       ArrayList<String> timePref = new ArrayList<String>();
                       ArrayList<Integer> dayPref = new ArrayList<Integer>();
                       int m =0;
                       if(timePreferred.equals("NIL"))timePref.add(0,"NIL");
                       else{
                           while (true) {
                               if ((((m+1) * 4)) ==  timePreferred.length()) {
                                   timePref.add(m,timePreferred.substring(m*4));
                                   break;
                               }
                               else
                               timePref.add(m, timePreferred.substring(m * 4, (m + 1) * 4));
                               m++;
                           }
                       }
                       m =0;
                       if (dayPreference.equals("NIL")) dayPref.add(0,0);
                       else {
                           while (true) {
                               dayPref.add(dayPreference.charAt(m) - '0');
                               m++;
                               if (m  == dayPreference.length()) break;

                           }
                       }
                       slots.add(k, new Slot(duration, dayPref, timePref));

                   }
                   batchCourseDetails.get(j).setSlots(slots);
               }

               batchCoursesCollection = new BatchCoursesCollection(numberOfCourses,batchCourseDetails);

               batchCoursesCollection.ComputeTimeTable();
               batchCoursesCollection.DisplayTimeTable();


           }

      }
}
