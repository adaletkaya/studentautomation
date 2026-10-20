package com.studentautomation.model;

public class Student extends Person {
    private int studentNumber;
    private String department;
    private int gradeLevel;
    private double gpa;

    public Student() {
        super();
    }

    public Student(int id, String name, String surname, String password, int studentNumber, String department, int gradeLevel, double gpa) {
        super(id, name, surname, password);
        this.studentNumber = studentNumber;
        this.department = department;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student Number : " + studentNumber);
        System.out.println("Department     : " + department);
        System.out.println("Grade Level    : " + gradeLevel);
        System.out.println("GPA            : " + gpa);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nStudent Number: " + studentNumber +
                "\nDepartment: " + department +
                "\nGrade Level: " + gradeLevel +
                "\nGPA: " + gpa;
    }
}
