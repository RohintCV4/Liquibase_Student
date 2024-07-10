package com.example.LiquiStd.controller;

import com.example.LiquiStd.entity.Course;
import com.example.LiquiStd.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course/v1")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/create-course")
    public Course createCourse(@RequestBody Course course) {
        return this.courseService.createCourse(course);
    }

    @DeleteMapping("/delete-course/{id}")
    public Map<String, Object> removeCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

    @GetMapping("/ascdes")
    public List<Course> retrieveCourse(@RequestParam String dem, Sort.Direction direction) {
        return this.courseService.retrieveCourse(dem, direction);
    }

    @GetMapping("/search")
    public List<Course> searchCourse(
            @RequestParam(required = false) String name, @RequestParam(required = false) Long fees) {
        return courseService.searchCourse(name, fees);
    }

    @PutMapping("/update-course/{id}")
    public Map<String, Object> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }
}