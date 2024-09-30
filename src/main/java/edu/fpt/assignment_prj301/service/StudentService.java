package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.Students;
import edu.fpt.assignment_prj301.entity.Subjects;
import edu.fpt.assignment_prj301.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired private StudentsRepository repo;
    public List<Students> listAll() {
        return (List<Students>) repo.findAll();
    }
    public void save(Students Students) {
        repo.save(Students);
    }
    public Students getStudents(Integer id){
        return repo.findById(id)
              .orElseThrow(() -> new RuntimeException("Students not found"));
    }
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
