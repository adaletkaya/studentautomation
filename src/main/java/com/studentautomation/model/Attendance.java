package com.studentautomation.model;

public class Attendance {
    private int id;
    private Student student;
    private Course course;
    private int absenceCount;

    public Attendance() {
    }

    public Attendance(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.absenceCount = 0;
    }

    public void addAbsence() {
        absenceCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getAbsenceCount() {
        return absenceCount;
    }
}
