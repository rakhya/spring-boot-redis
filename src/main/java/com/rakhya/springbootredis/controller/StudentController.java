package com.rakhya.springbootredis.controller;

import com.rakhya.springbootredis.domain.Student;
import com.rakhya.springbootredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Student retrieveStudent(@PathVariable final long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseBody
    public Student storeStudent(@RequestBody final Student student){
        studentService.persistStudent(student);
        return studentService.getStudentById(student.getId());
    }

    @GetMapping
    @ResponseBody
    public List<Student> retrieveAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable final long id){
        studentService.removeStudentById(id);
        if (null == studentService.getStudentById(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
