package edu.fpt.assignment_prj301.controller;

import edu.fpt.assignment_prj301.entity.Teachers;
import edu.fpt.assignment_prj301.entity.Teachers;
import edu.fpt.assignment_prj301.service.TeachersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static java.lang.System.out;

@Controller

public class TeachersController {
    @Autowired
    private TeachersService service;
    @GetMapping("Teachers/profile")
    public String viewProfile(HttpSession session, Model model) {
        Integer id = Integer.parseInt(session.getAttribute("id").toString());
        if (id.describeConstable().isEmpty()) {
            return "redirect:/login";
        }
        Teachers teachers = service.getTeachers(id);
        if (teachers == null) {
            model.addAttribute("error", "Teacher not found.");
            return "redirect:/home";
        }
        model.addAttribute("teachers", teachers);
        return "Profile";
    }
}
