package com.studentautomation.model;

public class Course {
    private int courseId;
    private String courseName;
    private int credit;
    private Teacher teacher;

    public Course() {
    }

    public Course(int courseId, String courseName, int credit, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.teacher = teacher;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void displayInfo() {
        System.out.println("Course ID   : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credit      : " + credit);

        if (teacher != null) {
            System.out.println("Teacher     : " + teacher.getName() + " " + teacher.getSurname());
        } else {
            System.out.println("Teacher     : Not Assigned");
        }
    }
}
