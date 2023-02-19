package com.StudentReport.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentReport.Entity.Student;
import com.StudentReport.Exception.StudentException;
import com.StudentReport.Service.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	StudentService sService;
	
	
	@PostMapping("/Student")
	public Student addStudent(@RequestBody Student student) throws StudentException{
		// by using this API we can add the student in database
		return sService.addStudent(student);
	}
	
	@PutMapping("/Student/{roll}/{semester}/{marks}/{subject}")
	public Student addMarksOfStudent(@PathVariable int roll, @PathVariable int semester, @PathVariable int marks, @PathVariable String subject) throws StudentException {
		// by using this API we can update mark of student for that we have to provide
		// Marks, Semester, roll and Subject(please write subject like english, math and science)
		return sService.addMarksOfStudent(roll, semester, marks, subject);
	}
	
	@GetMapping("/AverageOfSemester/{semester}")
	public double getAverageOfSemester(@PathVariable int semester) throws StudentException {
		// by using this API we can get Average marks of all student in semester
		// please note that semester are only 2 that why provide valid semester else you get
		// studentexception
		return sService.averagePercentageOfSemeter(semester);
	}
	
	@GetMapping("/AverageOfSubject/{semester}/{subject}")
	public double getAverageOfSubject(@PathVariable int semester, @PathVariable String subject) throws StudentException {
		// by using this API we can get Average marks of subject for that you have to provide
		// semester between 1 or 2 AND subject in lowercase
		return sService.averageMarkOfStudent(semester, subject);
	}
	
	
	@GetMapping("/getToper/{semester}")
	public List<Student> getTopTwoStudent(int semester) throws StudentException{
		// by using this API we can get TOP two student in both semester
		return sService.topTwoStudent(semester);
	}
}
