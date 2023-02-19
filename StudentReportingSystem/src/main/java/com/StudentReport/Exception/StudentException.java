package com.StudentReport.Exception;

public class StudentException extends Exception {

	
	public StudentException() {
		// this exception use if you don't have to provide massage
	}
	
	
	public StudentException(String msg) {
		// this exception use if you have to provide massage
		super(msg);
	}
}
