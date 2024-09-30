package edu.fpt.assignment_prj301.entity.relationship;

import edu.fpt.assignment_prj301.entity.Subjects;
import edu.fpt.assignment_prj301.entity.Teachers;
import jakarta.persistence.*;

@Entity
@Table(name="Teaching")
public class Teaching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Teach_Id;
    private int Class_Id;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teachers teacher;

    public int getTeach_Id() {
        return Teach_Id;
    }

    public void setTeach_Id(int teach_Id) {
        Teach_Id = teach_Id;
    }

    public int getClass_Id() {
        return Class_Id;
    }

    public void setClass_Id(int class_Id) {
        Class_Id = class_Id;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }
}
