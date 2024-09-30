package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.Subjects;
import edu.fpt.assignment_prj301.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServices {
    @Autowired private SubjectsRepository repo;
    public List<Subjects> listAll() {
        return (List<Subjects>) repo.findAll();
    }
}
