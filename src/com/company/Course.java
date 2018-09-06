package com.company;

public class Course {

    private String CourseName;
    private String CourseCode;

    public Course(String courseName, String courseCode) {
        CourseName = courseName;
        CourseCode = courseCode;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getCourseCode() {
        return CourseCode;
    }

}
