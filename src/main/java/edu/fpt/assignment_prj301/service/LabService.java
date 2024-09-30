package edu.fpt.assignment_prj301.service;

import edu.fpt.assignment_prj301.entity.Lab;
import edu.fpt.assignment_prj301.repository.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabService {
    @Autowired
    private LabRepository labRepository;
    public List<Lab> getLabs() {
        return (List<Lab>) labRepository.findAll();
    }
    public void save(Lab Lab) {
        labRepository.save(Lab);
    }
    public void delete(Integer id) {
        labRepository.deleteById(id);
    }
    public void edit(Integer id, Lab Lab) {
        Optional<Lab> lab = labRepository.findById(id);
        if(lab.isPresent()) {
            Lab lab1 = lab.get();
            lab1.setLab_Description(Lab.getLab_Description());
            lab1.setLab_Name(Lab.getLab_Name());
            lab1.setLab_CreateDate(Lab.getLab_CreateDate());
            lab1.setLab_ExpiredDate(Lab.getLab_ExpiredDate());
            lab1.setSubject_Id(Lab.getSubject_Id());
            labRepository.save(lab1);
        }
    }
}
