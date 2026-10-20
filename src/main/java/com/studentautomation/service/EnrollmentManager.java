package com.studentautomation.service;

import com.studentautomation.model.Course;
import com.studentautomation.model.Enrollment;
import com.studentautomation.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EnrollmentManager {
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public void enroll(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        enrollment.setId(idCounter.getAndIncrement());
        enrollments.add(enrollment);
    }

    public List<Enrollment> listByCourse(int courseId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourse().getCourseId() == courseId) {
                result.add(e);
            }
        }
        return result;
    }

    public void remove(int enrollmentId) {
        enrollments.removeIf(e -> e.getId() == enrollmentId);
    }
}
