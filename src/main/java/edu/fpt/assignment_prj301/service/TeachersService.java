package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.Teachers;
import edu.fpt.assignment_prj301.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersService {
    @Autowired
    private TeacherRepository repo;
    public List<Teachers> listAll() {
        return (List<Teachers>) repo.findAll();
    }
    public void save(Teachers Teachers) {
        repo.save(Teachers);
    }
    public Teachers getTeachers(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teachers not found"));
    }
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
