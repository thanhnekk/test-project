package edu.fpt.assignment_prj301.repository;

import edu.fpt.assignment_prj301.entity.Subjects;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectsRepository extends CrudRepository<Subjects, Integer> {
    @Query("SELECT DISTINCT s FROM Subjects s JOIN s.classes c JOIN c.learnings l WHERE l.student.Student_Id = :studentId")
    List<Subjects> findByStudentId(@Param("studentId") int studentId);
    @Query("SELECT DISTINCT s FROM Subjects s JOIN Teaching t ON s.Subject_Id = t.subject.Subject_Id WHERE t.teacher.Teacher_Id = :teacherId")
    List<Subjects> findByTeacherId(@Param("teacherId") int teacherId);
}

