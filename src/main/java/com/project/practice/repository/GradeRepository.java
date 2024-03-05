package com.project.practice.repository;

import java.util.ArrayList;
import java.util.List;

import com.project.practice.Grade;

public class GradeRepository {
    private List<Grade> studentGrades = new ArrayList<>();

    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(int index, Grade grade) {
        studentGrades.set(index, grade);
    }

    public List<Grade> getGrades() {
        return this.studentGrades;
    }
}