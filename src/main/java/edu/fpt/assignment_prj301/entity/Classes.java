package edu.fpt.assignment_prj301.entity;

import edu.fpt.assignment_prj301.entity.relationship.Learning;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="Classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Class_Id;
    @Column(nullable = false, unique = true, length = 45)
    private String Class_Name;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subjects subject;
    @OneToMany(mappedBy = "aClass")
    private List<Learning> learnings;


    public Classes() {

    }

    public int getClass_Id() {
        return Class_Id;
    }

    public void setClass_Id(int class_Id) {
        Class_Id = class_Id;
    }

    public String getClass_Name() {
        return Class_Name;
    }

    public void setClass_Name(String class_Name) {
        Class_Name = class_Name;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public List<Learning> getLearnings() {
        return learnings;
    }

    public void setLearnings(List<Learning> learnings) {
        this.learnings = learnings;
    }
}
