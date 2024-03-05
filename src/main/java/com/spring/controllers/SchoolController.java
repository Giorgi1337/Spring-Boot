package com.spring.controllers;

import com.spring.dto.SchoolDTO;
import com.spring.service.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDTO create(@RequestBody SchoolDTO dto) {
        return schoolService.create(dto);
    }

    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        return schoolService.findAll();
    }
}
