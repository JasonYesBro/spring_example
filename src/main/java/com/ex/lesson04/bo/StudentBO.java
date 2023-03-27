package com.ex.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.lesson04.dao.StudentMapper;
import com.ex.lesson04.model.Student;

@Service
public class StudentBO {
	
	@Autowired
	StudentMapper studentMapper;
	
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
		
	}
}
