package edu.fpt.assignment_prj301.repository;

import edu.fpt.assignment_prj301.entity.relationship.Learning;
import org.springframework.data.repository.CrudRepository;

public interface LearningRepository extends CrudRepository<Learning, Integer> {
}
