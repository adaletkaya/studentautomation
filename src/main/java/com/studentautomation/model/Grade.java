package com.studentautomation.model;

public class Grade {
    private int id;
    private Student student;
    private Course course;
    private double midterm;
    private double finalExam;

    public Grade() {
    }

    public Grade(Student student, Course course, double midterm, double finalExam) {
        this.student = student;
        this.course = course;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public double calculateAverage() {
        return midterm * 0.4 + finalExam * 0.6;
    }

    public void calculateLetterGrade() {
        System.out.println(getLetterGrade());
    }


    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 85) {
            return "AA";
        } else if (avg >= 75) {
            return "BA";
        } else if (avg >= 65) {
            return "BB";
        } else if (avg >= 57) {
            return "CB";
        } else if (avg >= 50) {
            return "CC";
        } else {
            return "KALDI";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public double getMidterm() {
        return midterm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
}
