package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.relationship.Learning;
import edu.fpt.assignment_prj301.repository.LearningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearningService {
    @Autowired
    private LearningRepository learningRepository;
    public List<Learning> getAllLearning(){
        return (List<Learning>) learningRepository.findAll();
    }
    public List<Learning> FindByClassId(int id){
        List<Learning> l= new ArrayList<>();
        for(Learning l1: learningRepository.findAll()){
            if (l1.getaClass().getClass_Id()==id)
                l.add(l1);
        }
        return l;
    }
}
