package edu.fpt.assignment_prj301;

import edu.fpt.assignment_prj301.entity.Classes;
import edu.fpt.assignment_prj301.entity.Lab;
import edu.fpt.assignment_prj301.entity.Students;
import edu.fpt.assignment_prj301.entity.Subjects;
import edu.fpt.assignment_prj301.entity.relationship.Learning;
import edu.fpt.assignment_prj301.repository.*;
import edu.fpt.assignment_prj301.service.SubjectServices;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class AssignmentPrj301ApplicationTests {

	@Autowired
	private StudentsRepository repo;
	@Autowired
	private SubjectsRepository subjectServices;
	@Autowired
	private ClassesRepository classesRepo;
	@Autowired
	private LabRepository labRepo;
	@Autowired
	private LearningRepository learningRepo;
	@Test
	public void testListAll() {
		Iterable<Students> stu = repo.findAll();
		Assertions.assertThat(stu).hasSizeGreaterThan(0);

		for (Students students : stu) {
			System.out.println(students);
		}
	}
	@Test
	public void testAddNewSubjects() {
		Subjects Subjects = new Subjects();
		Subjects.setSubject_Name("Object-Oriented Programming");
		Subjects savedSubjects = subjectServices.save(Subjects);
		Assertions.assertThat(savedSubjects).isNotNull();
		Assertions.assertThat(savedSubjects.getSubject_Id()).isGreaterThan(0);
	}
	@Test
	public void testAddNewClass() {
		Classes Classes = new Classes();
		Classes.setClass_Name("SE1873");

		Classes savedClasses = classesRepo.save(Classes);
		Assertions.assertThat(savedClasses).isNotNull();
	}
	@Test
	public void testAddNewLab() {
		Lab Lab = new Lab();
		Lab.setLab_Description("Car Manager");
		Lab.setLab_Name("PRO_Lab01");
		Lab.setLab_CreateDate("2024/06/27");
		Lab.setLab_ExpiredDate("2024/07/5");
		Lab.setSubject_Id(4);
		Lab savedLab = labRepo.save(Lab);
		Assertions.assertThat(savedLab).isNotNull();
		Assertions.assertThat(savedLab.getSubject_Id()).isGreaterThan(0);
	}
	@Test
	public void testAddNewLearning() {
		Learning Learning = new Learning();
		Learning savedLearning = learningRepo.save(Learning);
		Assertions.assertThat(savedLearning).isNotNull();
		Assertions.assertThat(savedLearning.getLearn_Id()).isGreaterThan(0);
	}
}
