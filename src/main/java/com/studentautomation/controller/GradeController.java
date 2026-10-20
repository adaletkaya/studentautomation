package com.studentautomation.controller;

import com.studentautomation.model.Grade;
import com.studentautomation.service.CourseManager;
import com.studentautomation.service.GradeManager;
import com.studentautomation.service.StudentManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grades")
public class GradeController {

    private final GradeManager gradeManager;
    private final StudentManager studentManager;
    private final CourseManager courseManager;

    public GradeController(GradeManager gradeManager, StudentManager studentManager, CourseManager courseManager) {
        this.gradeManager = gradeManager;
        this.studentManager = studentManager;
        this.courseManager = courseManager;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("grades", gradeManager.listGrades());
        return "grades/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("students", studentManager.listStudents());
        model.addAttribute("courses", courseManager.listCourses());
        model.addAttribute("isEdit", false);
        return "grades/form";
    }

    @PostMapping
    public String create(@RequestParam int studentNumber, @RequestParam int courseId,
                          @RequestParam double midterm, @RequestParam double finalExam) {
        Grade grade = new Grade(studentManager.findStudent(studentNumber), courseManager.findCourse(courseId), midterm, finalExam);
        gradeManager.addGrade(grade);
        return "redirect:/grades";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Grade grade = gradeManager.findGrade(id);
        if (grade == null) {
            return "redirect:/grades";
        }
        model.addAttribute("grade", grade);
        model.addAttribute("students", studentManager.listStudents());
        model.addAttribute("courses", courseManager.listCourses());
        model.addAttribute("isEdit", true);
        return "grades/form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @RequestParam int studentNumber, @RequestParam int courseId,
                          @RequestParam double midterm, @RequestParam double finalExam) {
        Grade updated = new Grade(studentManager.findStudent(studentNumber), courseManager.findCourse(courseId), midterm, finalExam);
        gradeManager.updateGrade(id, updated);
        return "redirect:/grades";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        gradeManager.removeGrade(id);
        return "redirect:/grades";
    }
}
