package edu.fpt.assignment_prj301.repository;

import edu.fpt.assignment_prj301.entity.Teachers;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teachers,Integer> {
}
