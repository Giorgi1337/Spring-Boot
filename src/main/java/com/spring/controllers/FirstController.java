package com.spring.controllers;

import com.spring.model.Student;
import com.spring.reposiories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {
    private final StudentRepository repository;
    @Autowired
    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(Student student, @PathVariable("student-id") Integer id) {
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(@PathVariable("student-name") String name) {
        return repository.findAllByFirstName(name);
    }

    @DeleteMapping("students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("student-id") Integer id) {
        repository.deleteById(id);
    }
}
