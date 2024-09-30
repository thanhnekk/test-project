package edu.fpt.assignment_prj301.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Lab")
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Lab_Id;
    @Column(nullable = false, length = 45)
    private String Lab_Name;
    @Column(nullable = false, length = 250)
    private String Lab_Description;
    @Column(nullable = false, length = 45)
    private String Lab_CreateDate;
    @Column(nullable = false, length = 45)
    private String Lab_ExpiredDate;
    @Column(nullable = false, length = 45)
    private int Subject_Id;

    public int getLab_Id() {
        return Lab_Id;
    }

    public void setLab_Id(int lab_Id) {
        Lab_Id = lab_Id;
    }

    public String getLab_Name() {
        return Lab_Name;
    }

    public void setLab_Name(String lab_Name) {
        Lab_Name = lab_Name;
    }

    public String getLab_Description() {
        return Lab_Description;
    }

    public void setLab_Description(String lab_Description) {
        Lab_Description = lab_Description;
    }

    public String getLab_CreateDate() {
        return Lab_CreateDate;
    }

    public void setLab_CreateDate(String lab_CreateDate) {
        Lab_CreateDate = lab_CreateDate;
    }

    public String getLab_ExpiredDate() {
        return Lab_ExpiredDate;
    }

    public void setLab_ExpiredDate(String lab_ExpiredDate) {
        Lab_ExpiredDate = lab_ExpiredDate;
    }

    public int getSubject_Id() {
        return Subject_Id;
    }

    public void setSubject_Id(int subject_Id) {
        Subject_Id = subject_Id;
    }
}
