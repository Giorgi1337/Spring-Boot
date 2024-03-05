package com.spring.controllers;

import com.spring.dto.StudentDTO;
import com.spring.dto.StudentResponseDTO;
import com.spring.model.School;
import com.spring.model.Student;
import com.spring.reposiories.StudentRepository;
import com.spring.service.StudentMapper;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@RequestBody StudentDTO dto) {
       return this.studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDTO findStudentById(Student student, @PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDTO> findStudentsByName(@PathVariable("student-name") String name) {
        return studentService.findStudentsByName(name);
    }

    @DeleteMapping("students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("student-id") Integer id) {
        studentService.deleteStudentById(id);
    }
}
