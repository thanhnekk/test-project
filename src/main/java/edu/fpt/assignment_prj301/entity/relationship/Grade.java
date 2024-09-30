package edu.fpt.assignment_prj301.entity.relationship;

import edu.fpt.assignment_prj301.entity.Students;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Grade_Id;
    @Column(nullable = false, length = 45)
    private int Lab_Id;
    @Column(nullable = false, length = 45)
    private int Student_Id;
    private String Submission_status;
    private String Submission_time;
    private String Submission_filepath;
    private String Score;
    @ManyToOne
    @JoinColumn(name = "Student_Id", insertable = false, updatable = false)
    private Students student;
    public Grade() {}
    public int getGrade_Id() {
        return Grade_Id;
    }

    public void setGrade_Id(int grade_Id) {
        Grade_Id = grade_Id;
    }

    public int getLab_Id() {
        return Lab_Id;
    }

    public void setLab_Id(int lab_Id) {
        Lab_Id = lab_Id;
    }

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
    }

    public String getSubmission_status() {
        return Submission_status;
    }

    public void setSubmission_status(String submission_status) {
        Submission_status = submission_status;
    }

    public String getSubmission_time() {
        return Submission_time;
    }

    public void setSubmission_time(String submission_time) {
        Submission_time = submission_time;
    }

    public String getSubmission_filepath() {
        return Submission_filepath;
    }

    public void setSubmission_filepath(String submission_filepath) {
        Submission_filepath = submission_filepath;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
}
