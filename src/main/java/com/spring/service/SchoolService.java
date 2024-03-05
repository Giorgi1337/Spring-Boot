package com.spring.service;

import com.spring.dto.SchoolDTO;
import com.spring.reposiories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDTO create(SchoolDTO schooldto) {
        var school = schoolMapper.toSchool(schooldto);
        schoolRepository.save(school);
        return schooldto;
    }

    public List<SchoolDTO> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());
    }
}
