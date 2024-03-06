package com.spring.service;


import com.spring.dto.StudentDTO;
import com.spring.dto.StudentResponseDTO;
import com.spring.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
   private StudentMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }
    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", exp.getMessage());
    }
    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDTO dto = new StudentDTO(
                "John",
                "Doe",
                "john123@gmail.com",
                1
        );
        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentResponse() {
        Student student = new Student(
                "Jane",
                "Smith",
                "jane123@gamil.com",
                25
        );
        StudentResponseDTO response = mapper.toStudentResponseDto(student);

        assertEquals(response.firstName(), student.getFirstName());
        assertEquals(response.lastName(), student.getLastName());
        assertEquals(response.email(), student.getEmail());
    }
}