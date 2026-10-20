package com.studentautomation.service;

import com.studentautomation.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentManager {
    private final ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> listStudents() {
        return students;
    }

    public Student findStudent(int studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(int studentNumber, Student updated) {
        Student existing = findStudent(studentNumber);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setSurname(updated.getSurname());
            existing.setPassword(updated.getPassword());
            existing.setDepartment(updated.getDepartment());
            existing.setGradeLevel(updated.getGradeLevel());
            existing.setGpa(updated.getGpa());
        }
    }

    public void removeStudent(int studentNumber) {
        Student student = findStudent(studentNumber);
        if (student != null) {
            students.remove(student);
        }
    }
}
