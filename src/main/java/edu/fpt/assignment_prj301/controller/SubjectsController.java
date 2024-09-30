package edu.fpt.assignment_prj301.controller;

import edu.fpt.assignment_prj301.entity.Students;
import edu.fpt.assignment_prj301.entity.Subjects;
import edu.fpt.assignment_prj301.entity.relationship.Grade;
import edu.fpt.assignment_prj301.repository.GradeRepository;
import edu.fpt.assignment_prj301.repository.LabRepository;
import edu.fpt.assignment_prj301.repository.StudentsRepository;
import edu.fpt.assignment_prj301.repository.SubjectsRepository;
import edu.fpt.assignment_prj301.service.GradeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SubjectsController {
    @Autowired
    private SubjectsRepository repo;
    @Autowired
    private LabRepository labRepository;
    @Autowired
    private StudentsRepository studentsRepository;
    @GetMapping("/course")
    public String course(Model model, HttpServletRequest request, HttpSession session) {
        int tid;
        int id= Integer.parseInt(session.getAttribute("id").toString());
        if (session.getAttribute("role") =="student") {
            List<Subjects> subjects = repo.findByStudentId(id);
            if (request.getParameter("Submit") != null) {
                tid = Integer.parseInt(request.getParameter("subjects"));
            } else {
                tid = subjects.get(0).getSubject_Id();
            }
            model.addAttribute("tid", tid);
            model.addAttribute("subjects", subjects);
            Students students = studentsRepository.findById(id).orElse(null);
            model.addAttribute("students", students);
        }
        else {
            List<Subjects> subjects = repo.findByTeacherId(id);
            if (request.getParameter("Submit") != null) {
                tid = Integer.parseInt(request.getParameter("subjects"));
            } else {
                tid = subjects.get(0).getSubject_Id();
            }
            model.addAttribute("tid", tid);
            model.addAttribute("subjects", subjects);
        }
        model.addAttribute("labs", labRepository.findAll());
        return "Course";
    }


}
