package edu.fpt.assignment_prj301.repository;

import edu.fpt.assignment_prj301.entity.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students, Integer> {
}
