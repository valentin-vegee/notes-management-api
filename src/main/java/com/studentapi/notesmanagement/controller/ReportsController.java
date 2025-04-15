package com.studentapi.notesmanagement.controller;

import com.studentapi.notesmanagement.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    private final GradeService gradeService;

    public ReportsController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Double> getAverageGradeForCourse(@PathVariable Long courseId) {
        double avg = gradeService.getAverageGradeForCourse(courseId);
        return ResponseEntity.ok(avg);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Double> getAverageGradeForStudent(@PathVariable Long studentId) {
        double avg = gradeService.getAverageGradeForStudent(studentId);
        return ResponseEntity.ok(avg);
    }
}
