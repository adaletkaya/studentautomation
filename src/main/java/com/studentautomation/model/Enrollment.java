package com.studentautomation.model;

public class Enrollment {
    private int id;
    private Student student;
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
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

    @Override
    public String toString() {
        return "Student:" + student.getName() +
                "| Course" + course.getCourseName();
    }
}
