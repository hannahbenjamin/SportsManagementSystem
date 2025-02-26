package com.example.cms.controller;

import com.example.cms.model.entity.CourseMark;
import com.example.cms.model.repository.CourseMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CourseMarkController {
    @Autowired
    private final CourseMarkRepository repository;

    public CourseMarkController(CourseMarkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/marks")
    List<CourseMark> retrieveAllMarks() {return repository.findAll();}

    @PostMapping("/marks/IncreaseFive/{code}")
    List<CourseMark> IncreaseFive(@PathVariable("code") String code) {
        // Call the repository method to update marks
        repository.IncreaseFive(code);

        // Return the updated list of marks
        return repository.findAll();
    }


}
