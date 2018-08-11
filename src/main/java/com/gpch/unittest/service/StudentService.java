package com.gpch.unittest.service;

import com.gpch.unittest.model.Student;
import com.gpch.unittest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No suitable translation provider found"));
    }

    public void deleteStudentById(int id){
        studentRepository.deleteById(id);
    }

    public Student createStudent(Student student){
        return  studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


}
