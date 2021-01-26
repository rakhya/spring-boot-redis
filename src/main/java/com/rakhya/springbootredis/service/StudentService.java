package com.rakhya.springbootredis.service;

import com.rakhya.springbootredis.domain.Student;
import com.rakhya.springbootredis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void persistStudent(final Student student) {
        studentRepository.save(student);
    }

    public void removeStudentById(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

}
