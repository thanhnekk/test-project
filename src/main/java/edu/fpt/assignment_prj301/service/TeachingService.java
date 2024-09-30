package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.relationship.Teaching;
import edu.fpt.assignment_prj301.repository.TeachingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachingService {
    @Autowired
    private TeachingRepository teachingRepository;
    public List<Teaching> getAllTeachings(){
        return (List<Teaching>) teachingRepository.findAll();
    }
    public List<Teaching> getTeachingByTid_and_Sid(int tid, int sid){
        List<Teaching> l= new ArrayList<>();
        for(Teaching teaching : getAllTeachings()){
            if (teaching.getTeacher().getTeacher_Id()==tid&&teaching.getSubject().getSubject_Id()==sid){
                l.add(teaching);
            }
        }
        return l;
    }
}
