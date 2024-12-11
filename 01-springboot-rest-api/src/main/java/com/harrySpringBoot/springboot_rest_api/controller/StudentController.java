package com.harrySpringBoot.springboot_rest_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.harrySpringBoot.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("student")
public class StudentController {
    
    // http://localhost:8080/student
    @GetMapping
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Harry", "Potter");
        // return new ResponseEntity<>(student , HttpStatus.OK);
        return  ResponseEntity.ok().header("custom-header", "harry").body(student);
    }
    
    // http://localhost:8080/students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Harry", "Potter"));
        students.add(new Student(2, "Harry", "Potter"));
        students.add(new Student(3, "Harry", "Potter"));
        return ResponseEntity.ok(students);
    }

    // Path Variable
    // http://localhost:8080/student/1/Harry/Potter
    @GetMapping("/{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,       @PathVariable String firstName,
            @PathVariable String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Request Params
    // http://localhost:8080/student/query?id=1&firstName=Harry&last-Name=Potter
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariale(@RequestParam int id,
                    @RequestParam String firstName,
            @RequestParam("last-Name") String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/student/create
    @PostMapping("/create")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    
    // http://localhost:8080/student/3/update
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/student/3/delete
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student delete successfully");
    }


}
