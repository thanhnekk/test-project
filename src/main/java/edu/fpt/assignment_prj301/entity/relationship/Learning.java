package edu.fpt.assignment_prj301.entity.relationship;

import edu.fpt.assignment_prj301.entity.Classes;
import edu.fpt.assignment_prj301.entity.Students;
import jakarta.persistence.*;

@Entity
@Table(name = "Learning")
public class Learning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Learn_Id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    private Classes aClass;
    public int getLearn_Id() {
        return Learn_Id;
    }

    public void setLearn_Id(int learn_Id) {
        Learn_Id = learn_Id;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Classes getaClass() {
        return aClass;
    }

    public void setaClass(Classes aClass) {
        this.aClass = aClass;
    }
}
