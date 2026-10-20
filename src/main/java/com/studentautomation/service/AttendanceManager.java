package com.studentautomation.service;

import com.studentautomation.model.Attendance;
import com.studentautomation.model.Course;
import com.studentautomation.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AttendanceManager {
    private final ArrayList<Attendance> records = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Attendance findOrCreate(Student student, Course course) {
        for (Attendance a : records) {
            if (a.getStudent().getStudentNumber() == student.getStudentNumber()
                    && a.getCourse().getCourseId() == course.getCourseId()) {
                return a;
            }
        }
        Attendance a = new Attendance(student, course);
        a.setId(idCounter.getAndIncrement());
        records.add(a);
        return a;
    }

    public void addAbsence(Student student, Course course) {
        findOrCreate(student, course).addAbsence();
    }

    public List<Attendance> listByCourse(int courseId) {
        List<Attendance> result = new ArrayList<>();
        for (Attendance a : records) {
            if (a.getCourse().getCourseId() == courseId) {
                result.add(a);
            }
        }
        return result;
    }
}
