package com.spring.controllers;

import com.spring.dto.StudentDTO;
import com.spring.dto.StudentResponseDTO;
import com.spring.model.School;
import com.spring.model.Student;
import com.spring.reposiories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository repository;
    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/students")
    public StudentResponseDTO post(@RequestBody StudentDTO studentdto) {
        var student = toStudent(studentdto);
        var savedStudent = repository.save(student);

        return toStudentResponseDto(savedStudent);
    }

    private Student toStudent(StudentDTO dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    private StudentResponseDTO toStudentResponseDto(Student student) {
          return new StudentResponseDTO(
                  student.getFirstName(),
                  student.getLastName(),
                  student.getEmail()
          );
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
