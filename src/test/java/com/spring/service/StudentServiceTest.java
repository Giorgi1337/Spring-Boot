package com.spring.service;

import com.spring.dto.StudentDTO;
import com.spring.dto.StudentResponseDTO;
import com.spring.model.Student;
import com.spring.reposiories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    // which service we want to test
    @InjectMocks
    private StudentService studentService;
    // declare the dependencies
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void should_successfully_save_a_student() {
        // Given
        StudentDTO dto = new StudentDTO(
          "John",
          "Doe",
          "john123@gmail.com",
          1
        );
       Student student = new Student(
               "John",
               "Doe",
               "john123@gmail.com",
               23
       );
       // Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(student);
        when(studentMapper.toStudentResponseDto(student)).thenReturn(
                new StudentResponseDTO(
                        "John",
                        "Doe",
                        "john123@gmail.com"
                ));
       // When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

       // Then
       assertEquals(dto.firstName(), responseDTO.firstName());
       assertEquals(dto.lastName(), responseDTO.lastName());
       assertEquals(dto.email(), responseDTO.email());

       verify(studentMapper, times(1)).toStudent(dto);
       verify(repository, times(1)).save(student);
       verify(studentMapper, times(1)).toStudentResponseDto(student);
    }

    @Test
    public void should_return_all_students() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "John",
                "Doe",
                "john123@gmail.com",
                23
        ));
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(
                new StudentResponseDTO(
                "John",
                "Doe",
                "john123@gmail.com"
        ));

        List<StudentResponseDTO> responseDTOS = studentService.findAllStudents();
        assertEquals(students.size(), responseDTOS.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void should_return_student_be_id() {
        Integer studentId = 1;
        Student student = new Student(
                "John",
                "Doe",
                "john123@gmail.com",
                23
        );
        when(repository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(
                new StudentResponseDTO(
                        "John",
                        "Doe",
                        "john123@gmail.com"
                ));

        StudentResponseDTO dto = studentService.findStudentById(studentId);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());

        verify(repository, times(1)).findById(studentId);
    }
}