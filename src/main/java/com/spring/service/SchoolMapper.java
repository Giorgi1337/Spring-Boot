package com.spring.service;

import com.spring.dto.SchoolDTO;
import com.spring.model.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDTO schooldto) {
        return  new School(schooldto.name());
    }
    public SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }
}
