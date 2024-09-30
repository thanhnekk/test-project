package edu.fpt.assignment_prj301.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Teacher")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Teacher_Id;
    @Column(nullable = false, length = 45)
    private String Teacher_Name;
    @Column(nullable = false, unique = true, length = 45)
    private String Teacher_userid;
    @Column(nullable = false, unique = true, length = 45)
    private String Teacher_Email;
    @Column(nullable = false, length = 20)
    private String Teacher_Password;
    @Column(nullable = false, columnDefinition = "BIT")
    private Boolean TeacherGender;
    @Column(nullable = false, length = 45)
    private String Teacher_Address;
    @Column(nullable = false, length = 20)
    private String Teacher_Phone;

    public int getTeacher_Id() {
        return Teacher_Id;
    }

    public void setTeacher_Id(int teacher_Id) {
        Teacher_Id = teacher_Id;
    }

    public String getTeacher_Name() {
        return Teacher_Name;
    }

    public void setTeacher_Name(String teacher_Name) {
        Teacher_Name = teacher_Name;
    }

    public String getTeacher_userid() {
        return Teacher_userid;
    }

    public void setTeacher_userid(String teacher_userid) {
        Teacher_userid = teacher_userid;
    }

    public String getTeacher_Email() {
        return Teacher_Email;
    }

    public void setTeacher_Email(String teacher_Email) {
        Teacher_Email = teacher_Email;
    }

    public String getTeacher_Password() {
        return Teacher_Password;
    }

    public void setTeacher_Password(String teacher_Password) {
        Teacher_Password = teacher_Password;
    }

    public Boolean getTeacherGender() {
        return TeacherGender;
    }

    public void setTeacherGender(Boolean teacherGender) {
        TeacherGender = teacherGender;
    }

    public String getTeacher_Address() {
        return Teacher_Address;
    }

    public void setTeacher_Address(String teacher_Address) {
        Teacher_Address = teacher_Address;
    }

    public String getTeacher_Phone() {
        return Teacher_Phone;
    }

    public void setTeacher_Phone(String teacher_Phone) {
        Teacher_Phone = teacher_Phone;
    }
}
