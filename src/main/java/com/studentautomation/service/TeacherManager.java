package com.studentautomation.service;

import com.studentautomation.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherManager {
    private final ArrayList<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> listTeachers() {
        return teachers;
    }

    public Teacher findTeacher(int teacherNumber) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherNumber() == teacherNumber) {
                return teacher;
            }
        }
        return null;
    }

    public void updateTeacher(int teacherNumber, Teacher updated) {
        Teacher existing = findTeacher(teacherNumber);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setSurname(updated.getSurname());
            existing.setPassword(updated.getPassword());
            existing.setBranch(updated.getBranch());
            existing.setSalary(updated.getSalary());
        }
    }

    public void removeTeacher(int teacherNumber) {
        Teacher teacher = findTeacher(teacherNumber);
        if (teacher != null) {
            teachers.remove(teacher);
        }
    }
}
