package com.example.LiquiStd.service;

import com.example.LiquiStd.entity.Student;
import com.example.LiquiStd.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Map<String, Object> updateStudent(Long id, Student studentRequest) {
        final Map<String, Object> responseMap = new HashMap<>();
        final Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            responseMap.put("Message", "ID Not found");
        } else {
            final Student studentResponse = student.get();
            if (studentRequest.getName() != null) {
                studentResponse.setName(studentRequest.getName());
            }
            if (studentRequest.getEmail() != null) {
                studentResponse.setEmail(studentRequest.getEmail());
            }
//            if (studentRequest.getAddress() != null) {
//                studentResponse.setAddress(studentRequest.getAddress());
//            }
            this.studentRepository.save(studentResponse);
            responseMap.put("Message", "Successfully Updated");

        }
        return responseMap;
    }
}

