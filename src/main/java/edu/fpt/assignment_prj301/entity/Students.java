package edu.fpt.assignment_prj301.entity;

import edu.fpt.assignment_prj301.entity.relationship.Grade;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Student_Id;
    @Column(nullable = false, length = 45)
    private String Student_Name;
    @Column(nullable = false, unique = true, length = 45)
    private String Student_userid;
    @Column(nullable = false, unique = true, length = 45)
    private String Student_Email;
    @Column(nullable = false, length = 20)
    private String Student_Password;
    @Column(nullable = false, columnDefinition = "BIT")
    private Boolean studentGender;
    @Column(nullable = false, length = 45)
    private String Student_Address;
    @Column(nullable = false, length = 20)
    private String Student_Phone;
    @OneToMany(mappedBy = "student")
    private List<Grade> grades;

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStudent_userid() {
        return Student_userid;
    }

    public void setStudent_userid(String student_userid) {
        Student_userid = student_userid;
    }

    public String getStudent_Email() {
        return Student_Email;
    }

    public void setStudent_Email(String student_Email) {
        Student_Email = student_Email;
    }

    public String getStudent_Password() {
        return Student_Password;
    }

    public void setStudent_Password(String student_Password) {
        Student_Password = student_Password;
    }

    public Boolean getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(Boolean studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudent_Address() {
        return Student_Address;
    }

    public void setStudent_Address(String student_Address) {
        Student_Address = student_Address;
    }

    public String getStudent_Phone() {
        return Student_Phone;
    }

    public void setStudent_Phone(String student_Phone) {
        Student_Phone = student_Phone;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
    public String getStatus_by_id(List<Grade> grades, int id) {
        for (Grade grade : grades) {
            if (grade.getLab_Id() == id) {
                return grade.getSubmission_status();
            }
        }
        return "Not Complete";
    }
    public String getSubmit_time_by_id(List<Grade> grades, int id) {
        for (Grade grade : grades) {
            if (grade.getLab_Id() == id) {
                return grade.getSubmission_time();
            }
        }
        return "N/A";
    }
    public String getSubmit_file_by_id(List<Grade> grades, int id) {
        for (Grade grade : grades) {
            if (grade.getLab_Id() == id) {
                return grade.getSubmission_filepath();
            }
        }
        return "N/A";
    }
    public String getSubmit_score_by_id(List<Grade> grades, int id) {
        for (Grade grade : grades) {
            if (grade.getLab_Id() == id) {
                return grade.getScore();
            }
        }
        return "N/A";
    }
}
