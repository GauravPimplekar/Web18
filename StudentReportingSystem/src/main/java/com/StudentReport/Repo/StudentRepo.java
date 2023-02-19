package com.StudentReport.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentReport.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	// this method return List of student by jpa repository
	public List<Student> findBySemester(int semester);
}
