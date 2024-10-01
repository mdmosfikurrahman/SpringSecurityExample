package com.spring.springsecurityexample.controller;

import com.spring.springsecurityexample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final List<Student> students = new ArrayList<>(List.of(
                    new Student(1, "Mosfik", 60),
                    new Student(2, "Farzana", 99)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public List<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return students;
    }

}
