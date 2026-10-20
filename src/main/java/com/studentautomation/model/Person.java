package com.studentautomation.model;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String password;

    public Person() {
    }

    public Person(int id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayInfo() {
        System.out.println("ID          :" + id);
        System.out.println("Name        :" + name);
        System.out.println("Surname     :" + surname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
