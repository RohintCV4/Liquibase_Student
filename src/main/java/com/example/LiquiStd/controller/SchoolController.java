package com.example.LiquiStd.controller;


import com.example.LiquiStd.entity.School;
import com.example.LiquiStd.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/school/v1")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/create-school")
    public School createSchool(@RequestBody School school) {
        return this.schoolService.createSchool(school);
    }

    @DeleteMapping("/delete-school/{id}")
    public Map<String, Object> removeSchool(@PathVariable Long id) {

        return schoolService.deleteSchool(id);
    }

    @GetMapping("/get-school/{id}")
    public Optional<School> retrieveSchool(@PathVariable Long id) {
        return this.schoolService.retrieveSchool(id);
    }

    @PutMapping("/update-school/{id}")
    public Map<String, Object> updateSchool(@PathVariable Long id, @RequestBody School school) {

        return schoolService.updateSchool(id, school);
    }

    // API
//	@GetMapping("https://reqres.in/api/users?page=2")
//	public String getMethodName(@RequestParam String param) {
//		return new String();
//	}

}

