package com.example.LiquiStd.controller;

import com.example.LiquiStd.entity.Student;
import com.example.LiquiStd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("create-student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-student/{id}")
    public Map<String, Object> updateSchool(@PathVariable Long id, @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

}

