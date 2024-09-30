package edu.fpt.assignment_prj301.controller;

import edu.fpt.assignment_prj301.entity.Students;
import edu.fpt.assignment_prj301.entity.Teachers;
import edu.fpt.assignment_prj301.service.StudentService;
import edu.fpt.assignment_prj301.service.TeachersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @Autowired
    private StudentService service;
    @Autowired
    private TeachersService teachersService;
    @GetMapping("/profile")
    public String viewProfile(HttpSession session, Model model) {
        Integer id = Integer.parseInt(session.getAttribute("id").toString());
        String role = session.getAttribute("role").toString();
        if (id.describeConstable().isEmpty()) {
            return "redirect:/login";
        }
        if ("student".equals(role)) {
            Students student = service.getStudents(id);
            if (student == null) {
                model.addAttribute("error", "Student not found.");
                return "redirect:/home";
            }
            model.addAttribute("student", student);
        }
        if ("teacher".equals(role)) {
            Teachers teachers = teachersService.getTeachers(id);
            if (teachers == null) {
                model.addAttribute("error", "Teacher not found.");
                return "redirect:/home";
            }
            model.addAttribute("teachers", teachers);
        }
        return "Profile";
    }

}
