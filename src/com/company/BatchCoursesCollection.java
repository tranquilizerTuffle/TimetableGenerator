package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class BatchCoursesCollection {

    private int NumberOfCourses;
    private ArrayList<BatchCourseDetails> batchCourseDetails;
    private TimeTable timeTable;

    public BatchCoursesCollection(int numberOfCourses, ArrayList<BatchCourseDetails> batchCourseDetails) {
        NumberOfCourses = numberOfCourses;
        this.batchCourseDetails = batchCourseDetails;
        timeTable = new TimeTable();
    }

    public int getNumberOfCourses() {
        return NumberOfCourses;
    }

    public ArrayList<BatchCourseDetails> getBatchCourseDetails() {
        return batchCourseDetails;
    }

    public void ComputeTimeTable() {

        int currentPreference = min();

        int currentSlot = 1;
        boolean flag = false;
        int check = 0;

        while (true) {
            flag = false;
            for (BatchCourseDetails mbatchCourseDetails : batchCourseDetails) {
                if ((mbatchCourseDetails.getPreference()) == currentPreference) {
                    flag = true;
                    int numberOfSlots = mbatchCourseDetails.getNumberOfSlots();
                    if (numberOfSlots < currentSlot) {
                        currentPreference++;
                        check++;
                        continue;
                    }
                    ArrayList<Slot> slots = mbatchCourseDetails.getSlots();

                    ArrayList<String> timePreferred = slots.get(currentSlot - 1).getTimePreference();
                    ArrayList<Integer> dayPreferred = slots.get(currentSlot - 1).getDayPreference();
                    int duration = slots.get(currentSlot - 1).getDuration();

                    String[][] day = timeTable.getWeek();
                    boolean slotAvailable = false;


                    for (String time : timePreferred) {
                        int timeInt = SlotToInt(time);
                        if (timeInt == 0) break;

                        for (Integer integer : dayPreferred) {
                            if (integer == 0) break;
                            slotAvailable = AllotmentWithCheck(integer, timeInt, duration, slotAvailable,
                                    mbatchCourseDetails.getCourseCode(),mbatchCourseDetails.getCourseName(),mbatchCourseDetails
                                            .getFacultyName(),duration);
                            if (slotAvailable) break;
                        }
                        if (slotAvailable) break;
                        //End of 1st Attempt

                        ArrayList<Integer> leastNotAvailable = new ArrayList<Integer>();
                        for (int i = 0; i < 5; i++) {
                            int least = leastWorkingDay(timeTable, leastNotAvailable);

                            leastNotAvailable.add(least);
                            if (least == 0) {
                                break;
                            } else {
                                slotAvailable = AllotmentWithCheck(least, timeInt, duration, slotAvailable,
                                        mbatchCourseDetails.getCourseCode(),mbatchCourseDetails.getCourseName(),mbatchCourseDetails
                                                .getFacultyName(),duration);
                                // System.out.println(mbatchCourseDetails.getCourseCode()+" "+ i+" "+least+" "+
                                //         timeTable.getWorkingHours()+" "+slotAvailable +" "+leastNotAvailable);
                                if (slotAvailable) break;
                            }

                            if (slotAvailable) break;
                        }


                        if (slotAvailable) break;

                        //end of 2nd attempt
                    }
                    if (slotAvailable) {
                        currentPreference++;
                        continue;
                    }
                    for (Integer integer : dayPreferred) {
                        if (integer == 0) break;
                        for (int i = 0; i < 7; i++) {
                            slotAvailable = AllotmentWithCheck(integer, i + 1, duration, slotAvailable,
                                    mbatchCourseDetails.getCourseCode(),mbatchCourseDetails.getCourseName(),mbatchCourseDetails
                                            .getFacultyName(),duration);
                            if (slotAvailable) break;
                        }
                        if (slotAvailable) break;
                    }
                    if (slotAvailable) {
                        currentPreference++;
                        continue;
                    }
                    ArrayList<Integer> leastNotAvailable = new ArrayList<Integer>();
                    for (int i = 0; i < 5; i++) {

                        int least = leastWorkingDay(timeTable, leastNotAvailable);

                        leastNotAvailable.add(least);
                        if (least == 0) {
                            //allot saturday
                            break;
                        } else {
                            for (int j = 0; j < 7; j++) {
                                slotAvailable = AllotmentWithCheck(least, j + 1, duration, slotAvailable,
                                        mbatchCourseDetails.getCourseCode(),mbatchCourseDetails.getCourseName(),mbatchCourseDetails
                                .getFacultyName(),duration);
                                if (slotAvailable) break;
                            }
                        }
                        if (slotAvailable) break;
                    }

                    if (slotAvailable) {
                        currentPreference++;
                        continue;
                    }
                    //attempt 6 over
                    //attempt 7 Saturday
                    for (int i = 0; i < 7; i++) {
                        timeTable.addSaturday(mbatchCourseDetails.getCourseCode()+" "+mbatchCourseDetails.getCourseName()+" " +mbatchCourseDetails
                                .getFacultyName());
                        slotAvailable = true;
                        timeTable.setWeek(day);
                        break;
                    }
                    if (slotAvailable) {
                        currentPreference++;
                        continue;
                    }
                }

            }
            if (currentPreference>maxPref()) {
                if (currentSlot > maxSlot()) break;
                else check = 0;
                currentPreference = min();
                currentSlot++;
            }

        }
    }


    private boolean AllotmentWithCheck(int integer, int timeInt, int duration, boolean slotAvailable,
                                       String courseCode, String courseName, String facultyName, int size) {
        String[][] day = timeTable.getWeek();
        if (day[integer - 1][timeInt - 1] == null) {
            if (duration == 1) {
                slotAvailable = true;
                AllotInTimeTable(integer, timeInt, duration, courseCode,courseName,facultyName,size);
            }
            if (duration == 2) {
                if (timeInt <= 6 && timeInt != 2 && timeInt != 4) {
                    if (day[integer - 1][timeInt] == null) {
                        slotAvailable = true;
                        AllotInTimeTable(integer, timeInt, duration, courseCode,courseName,facultyName,size);
                    }
                }
            }
            if (duration == 3) {
                if (timeInt == 5) {
                    if (day[integer - 1][timeInt] == null &&
                            day[integer - 1][timeInt + 1] == null) {
                        AllotInTimeTable(integer, timeInt, duration, courseCode,courseName,facultyName,size);
                        slotAvailable = true;
                    }
                }
            }
        }
        return slotAvailable;
    }

    private void AllotInTimeTable(int integer, int timeInt, int duration, String courseCode, String courseName
            ,String facultyName, int size) {

        String[][] day = timeTable.getWeek();
        int[][] weekDay = timeTable.getWeekSlot();
        int[] workingHours = timeTable.getWorkingHours();
        for (int i = 0; i < duration; i++) {
            day[integer - 1][timeInt - 1 + i] = courseCode + " " + courseName +" " + facultyName ;
            weekDay[integer-1][timeInt-1+i]=size;
            workingHours[integer - 1]++;
        }
    }

    private int leastWorkingDay(TimeTable timeTable, ArrayList<Integer> leastNotAvailable) {
        int least = 0;
        int max = 7;
        int[] hours = timeTable.getWorkingHours();
        for (int i = 0; i < 5; i++) {
            int ch = 1;
            if (hours[i] < max) {
                for (int m : leastNotAvailable) {
                    if ((m - 1) == i) ch = 0;
                }
                if (ch == 1) {
                    max = hours[i];
                    least = i;
                }
            }
        }
        if (max == 7) return 0;
        else return least + 1;
    }


    private int SlotToInt(String time) {
        int timeInt = 0;
        if (time.equals("0900")) timeInt = 1;
        if (time.equals("1000")) timeInt = 2;
        if (time.equals("1115")) timeInt = 3;
        if (time.equals("1215")) timeInt = 4;
        if (time.equals("0300")) timeInt = 5;
        if (time.equals("0400")) timeInt = 6;
        if (time.equals("0500")) timeInt = 7;
        return timeInt;
    }

    private int min() {

        int min = 10000;
        for (BatchCourseDetails mbatch : batchCourseDetails) {
            if (min > mbatch.getPreference()) {
                min = mbatch.getPreference();
            }
        }
        return min;
    }
    private int maxPref() {

        int max = -100;
        for (BatchCourseDetails mbatch : batchCourseDetails) {
            if (max < mbatch.getPreference()) {
                max = mbatch.getPreference();
            }
        }
        return max;
    }


    private int maxSlot() {
        int max = 0;
        for (BatchCourseDetails mbatch : batchCourseDetails) {
            if (max < mbatch.getNumberOfSlots()) {
                max = mbatch.getNumberOfSlots();
            }
        }
        return max;
    }

    public void DisplayTimeTable() {

        String[][] day = timeTable.getWeek();
        int endtime;
        {   for(int m=0;m<5;m++) {
            if(m==0)System.out.println("Monday");
            if(m==1)System.out.println("Tuesday");
            if(m==2)System.out.println("Wednesday");
            if(m==3)System.out.println("Thursday");
            if(m==4)System.out.println("Friday");
            for (int i = 0; i < 7; ) {

                endtime = EndOfClass(m,i);
                if (endtime != i) {
                    String endString = endtimeToString(endtime);
                    String startString = endtimeToString(i);
                    if (endtime ==4)
                        System.out.println(startString + "-1:15 " + day[m][i]);
                        else
                        if (endtime == 2) System.out.println(startString + "-11:00 " + day[m][i]);
                        else
                        System.out.println(startString + "-" + endString + " " + day[m][i]);


                    i = endtime;
                    continue;
                }
                i++;
            }
        } System.out.println("Saturday");
        ArrayList<String> saturday = timeTable.getSaturday();
        Collections.sort(saturday);
        for (String s : saturday)System.out.println(s);

        }
    }

    public int EndOfClass(int j,int i) {
        String[][] day = timeTable.getWeek();
        int endtime = i;
        int[][] weekday= timeTable.getWeekSlot();
        endtime= i+ weekday[j][i];
       /* {
            if (day[j][i] != null) {
                endtime = i + 1;
                if(i<6)if (day[j][i + 1] != null) {
                    if (day[j][i].equals(day[j][i + 1]) ){
                        endtime = i + 2;
                       if(i<5)if (day[j][i + 2] != null)
                            if (day[j][i].equals(day[j][i + 2])) {endtime = i + 3;}
                    }
                }
            }
        }*/
        if (i<4 && endtime>4)endtime=4;
        if(i<2 && endtime >2)endtime=2;
        return endtime;
    }

    private String endtimeToString(int endtime){
        if(endtime ==0)return "9:00";
        if(endtime ==1)return "10:00";
        if(endtime ==2)return "11:15";
        if(endtime ==3)return "12:15";
        if(endtime ==4)return "3:00";
        if(endtime ==5)return "4:00";
        if(endtime ==6)return "5:00";
        if(endtime ==7)return "6:00";
        return "";
    }

}
