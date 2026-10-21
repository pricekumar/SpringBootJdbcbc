package com.jdbc.springjdbc.service;

import com.jdbc.springjdbc.model.Student;
import com.jdbc.springjdbc.repository.StudentRepository;
import com.jdbc.springjdbc.repository.StudentRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getStudent();
    }

    public Student getStudentById(Long id)
    {
      return  studentRepository.getById(id);
    }

    public void deleteStudent(Long id) {
      studentRepository.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student,student.getId());
    }


}