package com.studentautomation.controller;

import com.studentautomation.model.Student;
import com.studentautomation.service.StudentManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentManager studentManager;

    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentManager.listStudents());
        return "students/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("isEdit", false);
        return "students/form";
    }

    @PostMapping
    public String create(@ModelAttribute Student student) {
        studentManager.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{studentNumber}")
    public String editForm(@PathVariable int studentNumber, Model model) {
        Student student = studentManager.findStudent(studentNumber);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        model.addAttribute("isEdit", true);
        return "students/form";
    }

    @PostMapping("/edit/{studentNumber}")
    public String update(@PathVariable int studentNumber, @ModelAttribute Student student) {
        studentManager.updateStudent(studentNumber, student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{studentNumber}")
    public String delete(@PathVariable int studentNumber) {
        studentManager.removeStudent(studentNumber);
        return "redirect:/students";
    }
}
