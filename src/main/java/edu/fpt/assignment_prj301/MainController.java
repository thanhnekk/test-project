package edu.fpt.assignment_prj301;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("home")
    public String showHomePage(HttpSession session) {
        if (session.getAttribute("role") != null) {
            return "Home_LoginSuccess";
        }
        else return "HomePage";
    }
    @RequestMapping("login")
    public String showLoginPage(HttpSession session) {
        if (session.getAttribute("role") != null) {
            return "Home_LoginSuccess";
        }
        return "Login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
    @GetMapping("home/success")
    public String showSuccessPage(HttpSession session) {
        if (session.getAttribute("role") != null) {
            return "Home_LoginSuccess";
        }
        return "Login";
    }
}

