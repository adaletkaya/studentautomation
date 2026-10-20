package com.studentautomation.service;

import com.studentautomation.model.Grade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GradeManager {
    private final ArrayList<Grade> grades = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public void addGrade(Grade grade) {
        grade.setId(idCounter.getAndIncrement());
        grades.add(grade);
    }

    public List<Grade> listGrades() {
        return grades;
    }

    public Grade findGrade(int id) {
        for (Grade grade : grades) {
            if (grade.getId() == id) {
                return grade;
            }
        }
        return null;
    }

    public void updateGrade(int id, Grade updated) {
        Grade existing = findGrade(id);
        if (existing != null) {
            existing.setStudent(updated.getStudent());
            existing.setCourse(updated.getCourse());
            existing.setMidterm(updated.getMidterm());
            existing.setFinalExam(updated.getFinalExam());
        }
    }

    public void removeGrade(int id) {
        Grade grade = findGrade(id);
        if (grade != null) {
            grades.remove(grade);
        }
    }
}
