package edu.fpt.assignment_prj301.controller;

import edu.fpt.assignment_prj301.entity.Classes;
import edu.fpt.assignment_prj301.entity.Lab;
import edu.fpt.assignment_prj301.entity.Students;
import edu.fpt.assignment_prj301.entity.relationship.Grade;
import edu.fpt.assignment_prj301.entity.relationship.Learning;
import edu.fpt.assignment_prj301.entity.relationship.Teaching;
import edu.fpt.assignment_prj301.repository.ClassesRepository;
import edu.fpt.assignment_prj301.repository.GradeRepository;
import edu.fpt.assignment_prj301.repository.LabRepository;
import edu.fpt.assignment_prj301.service.GradeService;
import edu.fpt.assignment_prj301.service.LabService;
import edu.fpt.assignment_prj301.service.StudentService;
import edu.fpt.assignment_prj301.service.TeachingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class LabController {
    @Autowired
    private LabService labService;
    @Autowired
    private LabRepository labRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private TeachingService teachingService;
    @Autowired
    private ClassesRepository classesRepository;

    @GetMapping("/labcrud")
    public String CrudLab(@RequestParam("submit") String submit, HttpServletRequest request) {
        if ("del".equals(submit)) {
            int labId = Integer.parseInt(request.getParameter("lab_id"));
            labService.delete(labId);
        }
        if ("insert".equals(submit)) {
            Lab lab = new Lab();
            lab.setLab_Description(request.getParameter("Lab_Description"));
            lab.setLab_Name(request.getParameter("Lab_Name"));
            lab.setLab_CreateDate(request.getParameter("Lab_CreateDate"));
            lab.setLab_ExpiredDate(request.getParameter("Lab_ExpiredDate"));
            lab.setSubject_Id(Integer.parseInt(request.getParameter("subject_id")));
            labService.save(lab);
        }
        if ("edit".equals(submit)) {
            int id=Integer.parseInt(request.getParameter("lab_id"));
            Lab lab = new Lab();
            lab.setLab_Description(request.getParameter("Lab_Description"));
            lab.setLab_Name(request.getParameter("Lab_Name"));
            lab.setLab_CreateDate(request.getParameter("Lab_CreateDate"));
            lab.setLab_ExpiredDate(request.getParameter("Lab_ExpiredDate"));
            lab.setSubject_Id(Integer.parseInt(request.getParameter("Subject_id")));
            labService.edit(id, lab);
        }
        return "redirect:/course";
    }
    @GetMapping("/editlab")
    public String editLab(@RequestParam("lab_id") int labId, Model model){
        model.addAttribute("lab_id", labId);
        return "EditLab";
    }
    @GetMapping("/viewlab/{labId}")
    public String viewLab(@PathVariable int labId, Model model, HttpSession session, HttpServletRequest request) {
        Lab lab = labRepository.findById(labId).orElseThrow(() -> new IllegalArgumentException("Invalid lab Id:" + labId));
        model.addAttribute("lab", lab);
        LocalDate expiredDate = LocalDate.parse(lab.getLab_ExpiredDate());
        LocalDate currentDate = LocalDate.now();
        boolean isExpired = expiredDate.isBefore(currentDate);
        model.addAttribute("isExpired", isExpired);
        String role = session.getAttribute("role").toString();
        int id= Integer.parseInt(session.getAttribute("id").toString());
        if ("student".equals(role)) {
            Grade grade = gradeService.getGradeByStudentId_and_LabId(id,labId);
            model.addAttribute("student_grade", grade);
            String submit = request.getParameter("submit");
            String submit_time = request.getParameter("submit_time");
            String submissionFilePath=request.getParameter("submissionFilePath");
            if (submit!=null&&submit_time!=null&&submissionFilePath!=null){
                Grade newGrade = new Grade();
                newGrade.setLab_Id(labId);
                newGrade.setStudent_Id(id);
                newGrade.setSubmission_status("Submitted");
                newGrade.setSubmission_filepath(submissionFilePath);
                newGrade.setScore("N/A");
                newGrade.setSubmission_time(submit_time);
                gradeRepository.save(newGrade);
            }

        } else if ("teacher".equals(role)) {
            List<Classes> newList = new ArrayList<>();
            List<Teaching> t= teachingService.getTeachingByTid_and_Sid(id,lab.getSubject_Id());
            for (Teaching teaching : t) {
                int classid = teaching.getClass_Id();
                boolean exists = false;
                for (Classes classes : newList) {
                    if (classes.getClass_Id() == classid) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    Optional<Classes> newClass = classesRepository.findById(classid);
                    newList.add(newClass.get());
                }
            }

            int tid=newList.get(0).getClass_Id();
            if (request.getParameter("Submit") != null) {
                tid = Integer.parseInt(request.getParameter("class_view"));
            }
            List<Students> students = new ArrayList<>();
            List<Learning> learnings = new ArrayList<>();
            for (Classes classes : newList) {
                if (classes.getClass_Id() == tid) {
                    learnings=classes.getLearnings();
                }
            }
            for (Learning learning : learnings) {
                System.out.println(learning.getLearn_Id());
                students.add(learning.getStudent());
                System.out.println(learning.getStudent());
            }
            if (Objects.equals(request.getParameter("submitgrade"), "grade")) {
                String grade=request.getParameter("grade");
                String studentId=request.getParameter("studentId");
                if (studentId!=null){
                    System.out.println(studentId);
                    Grade g = gradeService.getGradeByStudentId_and_LabId(Integer.parseInt(studentId), labId);
                    g.setScore(grade);
                    gradeRepository.save(g);
                }
                else System.out.println("student_id is null");
            }
            List<Grade> grades = gradeService.getGradeByLabId(labId);
            model.addAttribute("tid", tid);
            model.addAttribute("students", students);
            model.addAttribute("grade", grades);
            model.addAttribute("classes", newList);
        }
        return "LabView";
    }
}


