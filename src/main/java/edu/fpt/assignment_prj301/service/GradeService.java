package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.relationship.Grade;
import edu.fpt.assignment_prj301.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
    public Grade getGradeByStudentId_and_LabId(int stuid, int lab_id) {
        for (Grade grade : getAllGrades()) {
            if (grade.getStudent_Id()==stuid&&grade.getLab_Id()==lab_id) {
                return grade;
            }
        }
        return null;
    }
    public List<Grade> getGradeByLabId(int lab_id) {
        List<Grade> grades = getAllGrades();
        for (Grade grade : getAllGrades()) {
            if (grade.getLab_Id()==lab_id) {
                grades.add(grade);
            }
        }
        return grades;
    }
}
