package edu.fpt.assignment_prj301.repository;

import edu.fpt.assignment_prj301.entity.relationship.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Integer> {
}
