package com.studentapi.notesmanagement.service;

import com.studentapi.notesmanagement.model.Grade;
import com.studentapi.notesmanagement.repository.GradeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GradeService {
    
    private final GradeRepository gradeRepository;
    
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
    
    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }
    
    public Grade updateGrade(Long id, Grade gradeDetails) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note non trouvée"));
        grade.setGradeValue(gradeDetails.getGradeValue());
        return gradeRepository.save(grade);
    }
    
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
    
    public List<Grade> getGradesByStudent(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
    
    public List<Grade> getGradesByCourse(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }
    
    public double getAverageGradeForCourse(Long courseId) {
        List<Grade> grades = getGradesByCourse(courseId);
        return grades.stream().mapToDouble(Grade::getGradeValue).average().orElse(0.0);
    }
    
    public double getAverageGradeForStudent(Long studentId) {
        List<Grade> grades = getGradesByStudent(studentId);
        return grades.stream().mapToDouble(Grade::getGradeValue).average().orElse(0.0);
    }
}
