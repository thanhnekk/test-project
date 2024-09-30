package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.Classes;
import edu.fpt.assignment_prj301.entity.Subjects;
import edu.fpt.assignment_prj301.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    @Autowired private ClassesRepository repo;
    public List<Classes> getAll() {
        return (List<Classes>) repo.findAll();
    }
    public void testAddNewClass() {
        Classes Classes = new Classes();
        Classes.setClass_Name("SE1857");
        Classes savedClasses = repo.save(Classes);
    }
}
