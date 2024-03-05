package com.spring.service;

import com.spring.dto.StudentDTO;
import com.spring.dto.StudentResponseDTO;
import com.spring.model.School;
import com.spring.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDTO dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDTO toStudentResponseDto(Student student) {
        return new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
