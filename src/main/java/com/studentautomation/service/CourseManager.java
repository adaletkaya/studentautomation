package com.studentautomation.service;

import com.studentautomation.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseManager {
    private final ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> listCourses() {
        return courses;
    }

    public Course findCourse(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public void updateCourse(int courseId, Course updated) {
        Course existing = findCourse(courseId);
        if (existing != null) {
            existing.setCourseName(updated.getCourseName());
            existing.setCredit(updated.getCredit());
            existing.setTeacher(updated.getTeacher());
        }
    }

    public void removeCourse(int courseId) {
        Course course = findCourse(courseId);
        if (course != null) {
            courses.remove(course);
        }
    }
}
