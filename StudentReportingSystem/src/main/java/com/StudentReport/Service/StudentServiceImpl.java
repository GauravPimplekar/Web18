package com.StudentReport.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.StudentReport.Entity.Student;
import com.StudentReport.Exception.StudentException;
import com.StudentReport.Repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepo sRepo; // it is auto wired with student Repo interface

	@Override
	public Student addStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		
		// this method use to add student in database by using student Repo interface
		
		if(student != null) {
			Student student2 = sRepo.save(student);
			
			return student2;
		}
		else {
			throw new StudentException("Student not be null");
		}
		
		
	}

	@Override
	public Student addMarksOfStudent(int roll, int semester, int marks, String subject) throws StudentException {
		// TODO Auto-generated method stub
		
		Student student = sRepo.findById(roll).orElseThrow(() -> new StudentException("Student not found with roll ="+roll));
		
		if(student.getSemester() != semester) {
			
			// it's check of provided semester and student semester if not matching
			// then we get exception with proper massage
			throw new StudentException("please enter the valide semester details");
		}
		
		if(subject.equals("english")) {
			
			// it's matching subject with provided subject
			student.setEnglishMarks(marks);
		}
		else if(subject.equals("math")) {
			student.setMathMarks(marks);
		}
		else if(subject.equals("science")){
			student.setScienceMarks(marks);
		}
		else {
			throw new StudentException("please enter valide subject");
		}
		
		// in above please note that is you provide any upper case in subject then you get exception
		// with massage 
		
		sRepo.save(student);
		return student;
	}

	@Override
	public double averagePercentageOfSemeter(int semester) throws StudentException {
		// TODO Auto-generated method stub
		
		List<Student> studentList = sRepo.findBySemester(semester);
		
		// student List pointing List of student in provided semester
		
		if(studentList.size() == 0) {
			throw new StudentException("students is not available in semester = "+semester);
		}
		
		int totalClassMarks =0;
		int totalSubjectMarks = studentList.size()*300;
		for(int i=0; i<studentList.size(); i++) {
			totalClassMarks += studentList.get(i).getEnglishMarks();
			totalClassMarks += studentList.get(i).getMathMarks();
			totalClassMarks += studentList.get(i).getScienceMarks();
		}
		
		// totalClassMarks pointing sum of all student subjects
		// totalSubjectMarks pointing total of all subject marks
		
		int total = (totalClassMarks*100);
		
		double percentage = total/totalSubjectMarks;
		
		return percentage;
	}

	@Override
	public double averageMarkOfStudent(int semester, String subject) throws StudentException {
		// TODO Auto-generated method stub
		
		List<Student> studentList = sRepo.findBySemester(semester);
		
		// student List pointing List of student in provided semester
		
		if(studentList.size() == 0) {
			throw new StudentException("students is not available in semester = "+semester);
		}
		
		int totalClassMarks =0;
		
		for(int i=0; i<studentList.size(); i++) {
			
			if(subject.equals("english")) {
				totalClassMarks += studentList.get(i).getEnglishMarks();
			}
			else if(subject.equals("math")) {
				totalClassMarks += studentList.get(i).getMathMarks();
			}
			else if(subject.equals("science")) {
				totalClassMarks += studentList.get(i).getScienceMarks();
			}
			else {
				throw new StudentException("please enter valide subject");
			}
		}
		
		// totalClassMarks pointing sum of all student subjects
		
		double percentage = totalClassMarks/studentList.size();
		
		return percentage;
	}

	@Override
	public List<Student> topTwoStudent(int semester) {
		// TODO Auto-generated method stub
		
		// this method provide top two student from that semester
		
		List<Student> studentList = sRepo.findBySemester(semester);
		
		List<Student> topperStudent = new ArrayList<>();
		int max = 0;
		int removingIndex =0;
		
		for(int i=0; i<studentList.size(); i++) {
			int total =0;
			
			total += studentList.get(i).getEnglishMarks();
			total += studentList.get(i).getMathMarks();
			total += studentList.get(i).getScienceMarks();
			
			if(max < total) {
				max = total;
				removingIndex = i;
				
			}
		}
		
		
		
		topperStudent.add(studentList.get(removingIndex));
		studentList.remove(removingIndex);
		
		
		int removingIndex2 = 0;
		int max2 =0;
		for(int i=0; i<studentList.size(); i++) {
			int total =0;
			
			total += studentList.get(i).getEnglishMarks();
			total += studentList.get(i).getMathMarks();
			total += studentList.get(i).getScienceMarks();
			
			if(max2 < total && max2 != max) {
				max2 = total;
				removingIndex2 = i;
			}
		}
		
		topperStudent.add(studentList.get(removingIndex2));
		studentList.remove(removingIndex2);
		
		
		return topperStudent; 
	}

}
