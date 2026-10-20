package com.studentautomation.controller;

import com.studentautomation.service.CourseManager;
import com.studentautomation.service.GradeManager;
import com.studentautomation.service.StudentManager;
import com.studentautomation.service.TeacherManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final StudentManager studentManager;
    private final TeacherManager teacherManager;
    private final CourseManager courseManager;
    private final GradeManager gradeManager;

    public HomeController(StudentManager studentManager, TeacherManager teacherManager,
                           CourseManager courseManager, GradeManager gradeManager) {
        this.studentManager = studentManager;
        this.teacherManager = teacherManager;
        this.courseManager = courseManager;
        this.gradeManager = gradeManager;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("studentCount", studentManager.listStudents().size());
        model.addAttribute("teacherCount", teacherManager.listTeachers().size());
        model.addAttribute("courseCount", courseManager.listCourses().size());
        model.addAttribute("gradeCount", gradeManager.listGrades().size());
        return "home";
    }
}
