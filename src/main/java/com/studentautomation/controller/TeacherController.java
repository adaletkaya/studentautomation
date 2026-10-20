package com.studentautomation.controller;

import com.studentautomation.model.Teacher;
import com.studentautomation.service.TeacherManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherManager teacherManager;

    public TeacherController(TeacherManager teacherManager) {
        this.teacherManager = teacherManager;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("teachers", teacherManager.listTeachers());
        return "teachers/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("isEdit", false);
        return "teachers/form";
    }

    @PostMapping
    public String create(@ModelAttribute Teacher teacher) {
        teacherManager.addTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/edit/{teacherNumber}")
    public String editForm(@PathVariable int teacherNumber, Model model) {
        Teacher teacher = teacherManager.findTeacher(teacherNumber);
        if (teacher == null) {
            return "redirect:/teachers";
        }
        model.addAttribute("teacher", teacher);
        model.addAttribute("isEdit", true);
        return "teachers/form";
    }

    @PostMapping("/edit/{teacherNumber}")
    public String update(@PathVariable int teacherNumber, @ModelAttribute Teacher teacher) {
        teacherManager.updateTeacher(teacherNumber, teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{teacherNumber}")
    public String delete(@PathVariable int teacherNumber) {
        teacherManager.removeTeacher(teacherNumber);
        return "redirect:/teachers";
    }
}
