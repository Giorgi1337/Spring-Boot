package com.spring.controllers;

import com.spring.dto.SchoolDTO;
import com.spring.model.School;
import com.spring.reposiories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;
    @Autowired
    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    @PostMapping("/schools")
    public SchoolDTO create(@RequestBody SchoolDTO schooldto) {
        var school = toSchool(schooldto);
        schoolRepository.save(school);
        return schooldto;
    }
    private School toSchool(SchoolDTO schooldto) {
        return  new School(schooldto.name());
    }
    private SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }
    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDTO)
                .collect(Collectors.toList());
    }
}
