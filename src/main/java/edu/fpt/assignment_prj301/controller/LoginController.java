package edu.fpt.assignment_prj301.controller;

import edu.fpt.assignment_prj301.entity.Students;
import edu.fpt.assignment_prj301.service.StudentService;
import edu.fpt.assignment_prj301.service.TeachersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.fpt.assignment_prj301.entity.Teachers;
import java.util.List;

import static java.lang.System.out;
@Controller
public class LoginController {
    @Autowired
    private StudentService service;
    @Autowired
    private TeachersService serviceT;
    @PostMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, RedirectAttributes ra) {
        HttpSession ses = request.getSession(false);
        if (ses != null && ses.getAttribute("name") != null) {
            String name = (String) ses.getAttribute("name");
            out.print("Hello, " + name + "! You are already logged in.");
            return "redirect:/home/success";
        }
        int check=0;
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        List<Students> studentsList = service.listAll();
        for (Students student : studentsList) {
            if (student.getStudent_userid().equals(userid) && student.getStudent_Password().equals(password)) {
                check = 1;
                session.setAttribute("role", "student");
                session.setAttribute("name", student.getStudent_Name());
                session.setAttribute("id", student.getStudent_Id());
                return "redirect:/home/success";
            }
        }
        List<Teachers> teachersList = serviceT.listAll();
        for (Teachers teacher : teachersList) {
            if (teacher.getTeacher_userid().equals(userid) && teacher.getTeacher_Password().equals(password)) {
                check = 1;
                session.setAttribute("role", "teacher");
                session.setAttribute("name", teacher.getTeacher_Name());
                session.setAttribute("id", teacher.getTeacher_Id());
                return "redirect:/home/success";
            }
        }
        if (check==0&&userid!=null&&password!=null) {
            ra.addFlashAttribute("error", "Userid or password is wrong.");
            ra.addFlashAttribute("userid", userid);
        }
        return "redirect:/login";
    }


}
