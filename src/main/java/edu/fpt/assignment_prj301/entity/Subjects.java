package edu.fpt.assignment_prj301.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="Subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Subject_Id;
    @Column(nullable = false, length = 45)
    private String Subject_Name;
    @OneToMany(mappedBy = "subject")
    private Set<Classes> classes;
    public int getSubject_Id() {
        return Subject_Id;
    }

    public void setSubject_Id(int subject_Id) {
        Subject_Id = subject_Id;
    }

    public String getSubject_Name() {
        return Subject_Name;
    }

    public void setSubject_Name(String subject_Name) {
        Subject_Name = subject_Name;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }
}
