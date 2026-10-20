package com.studentautomation.controller;

import com.studentautomation.model.Course;
import com.studentautomation.model.Student;
import com.studentautomation.model.Teacher;
import com.studentautomation.service.AttendanceManager;
import com.studentautomation.service.CourseManager;
import com.studentautomation.service.EnrollmentManager;
import com.studentautomation.service.StudentManager;
import com.studentautomation.service.TeacherManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseManager courseManager;
    private final TeacherManager teacherManager;
    private final StudentManager studentManager;
    private final EnrollmentManager enrollmentManager;
    private final AttendanceManager attendanceManager;

    public CourseController(CourseManager courseManager, TeacherManager teacherManager,
                             StudentManager studentManager, EnrollmentManager enrollmentManager,
                             AttendanceManager attendanceManager) {
        this.courseManager = courseManager;
        this.teacherManager = teacherManager;
        this.studentManager = studentManager;
        this.enrollmentManager = enrollmentManager;
        this.attendanceManager = attendanceManager;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("courses", courseManager.listCourses());
        return "courses/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("teachers", teacherManager.listTeachers());
        model.addAttribute("isEdit", false);
        return "courses/form";
    }

    @PostMapping
    public String create(@ModelAttribute Course course, @RequestParam(required = false) Integer teacherNumber) {
        if (teacherNumber != null) {
            course.setTeacher(teacherManager.findTeacher(teacherNumber));
        }
        courseManager.addCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{courseId}")
    public String editForm(@PathVariable int courseId, Model model) {
        Course course = courseManager.findCourse(courseId);
        if (course == null) {
            return "redirect:/courses";
        }
        model.addAttribute("course", course);
        model.addAttribute("teachers", teacherManager.listTeachers());
        model.addAttribute("isEdit", true);
        return "courses/form";
    }

    @PostMapping("/edit/{courseId}")
    public String update(@PathVariable int courseId, @ModelAttribute Course course,
                          @RequestParam(required = false) Integer teacherNumber) {
        if (teacherNumber != null) {
            course.setTeacher(teacherManager.findTeacher(teacherNumber));
        }
        courseManager.updateCourse(courseId, course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{courseId}")
    public String delete(@PathVariable int courseId) {
        courseManager.removeCourse(courseId);
        return "redirect:/courses";
    }

    @GetMapping("/{courseId}")
    public String detail(@PathVariable int courseId, Model model) {
        Course course = courseManager.findCourse(courseId);
        if (course == null) {
            return "redirect:/courses";
        }
        List<com.studentautomation.model.Attendance> attendances = attendanceManager.listByCourse(courseId);
        Map<Integer, Integer> absenceByStudent = new HashMap<>();
        for (com.studentautomation.model.Attendance a : attendances) {
            absenceByStudent.put(a.getStudent().getStudentNumber(), a.getAbsenceCount());
        }

        model.addAttribute("course", course);
        model.addAttribute("enrollments", enrollmentManager.listByCourse(courseId));
        model.addAttribute("absenceByStudent", absenceByStudent);
        model.addAttribute("allStudents", studentManager.listStudents());
        return "courses/detail";
    }

    @PostMapping("/{courseId}/enroll")
    public String enroll(@PathVariable int courseId, @RequestParam int studentNumber) {
        Course course = courseManager.findCourse(courseId);
        Student student = studentManager.findStudent(studentNumber);
        if (course != null && student != null) {
            enrollmentManager.enroll(student, course);
        }
        return "redirect:/courses/" + courseId;
    }

    @PostMapping("/{courseId}/absence")
    public String addAbsence(@PathVariable int courseId, @RequestParam int studentNumber) {
        Course course = courseManager.findCourse(courseId);
        Student student = studentManager.findStudent(studentNumber);
        if (course != null && student != null) {
            attendanceManager.addAbsence(student, course);
        }
        return "redirect:/courses/" + courseId;
    }
}
