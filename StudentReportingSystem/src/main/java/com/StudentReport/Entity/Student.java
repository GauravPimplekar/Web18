package com.StudentReport.Entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.checkerframework.checker.units.qual.min;
import org.springframework.validation.annotation.Validated;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int roll; // note that roll no. is auto generated not need to provide
	String name;
	
	@Max(value = 2)
	@Min(value = 0)
	int semester;  // semester is only two 1 and 2
	
	@Max(value = 100)
	@Min(value = 0)
	int englishMarks; // max 100 marks you can provide to subject
	
	@Max(value = 100)
	@Min(value = 0)
	int mathMarks;  // max 100 marks you can provide to subject
	
	@Max(value = 100)
	@Min(value = 0)
	int scienceMarks;  // max 100 marks you can provide to subject
	
}
