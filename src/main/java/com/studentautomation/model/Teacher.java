package com.studentautomation.model;

public class Teacher extends Person {
    private int teacherNumber;
    private String branch;
    private double salary;

    public Teacher() {
        super();
    }

    public Teacher(int id, String name, String surname, String password, int teacherNumber, String branch, double salary) {
        super(id, name, surname, password);
        this.teacherNumber = teacherNumber;
        this.branch = branch;
        this.salary = salary;
    }

    public int getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(int teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Teacher Number :" + teacherNumber);
        System.out.println("Branch :        " + branch);
        System.out.println("Salary :        " + salary);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTeacher Number:" + teacherNumber +
                "\nBranch:" + branch +
                "\nSalary:" + salary;
    }
}
