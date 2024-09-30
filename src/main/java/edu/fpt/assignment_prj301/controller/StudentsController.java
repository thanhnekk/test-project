package edu.fpt.assignment_prj301.controller;

import edu.fpt.assignment_prj301.entity.Lab;
import edu.fpt.assignment_prj301.entity.Students;
import edu.fpt.assignment_prj301.service.LabService;
import edu.fpt.assignment_prj301.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    private StudentService service;
    @Autowired
    private LabService labService;
    @GetMapping("Students/profile")
    public String viewProfile(HttpSession session, Model model) {
        Integer id = Integer.parseInt(session.getAttribute("id").toString());
        if (id.describeConstable().isEmpty()) {
            return "redirect:/login";
        }
        Students student = service.getStudents(id);
        if (student == null) {
            model.addAttribute("error", "Student not found.");
            return "redirect:/home";
        }
        model.addAttribute("student", student);
        return "Profile";
    }
    @GetMapping("/grade")
    public String grade(HttpSession session, Model model) {
        Integer id = Integer.parseInt(session.getAttribute("id").toString());
        Students student = service.getStudents(id);
        List<Lab> labs = labService.getLabs();
        model.addAttribute("student", student);
        model.addAttribute("labs", labs);
        return "Grade";
    }

}
