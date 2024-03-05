package com.project.practice.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.practice.Grade;
import com.project.practice.service.GradeService;

import jakarta.validation.Valid;

@Controller
public class GradeController {

    GradeService gradeService = new GradeService();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

    @PostMapping("/handleSubmit")
    public String submitGradeForm(@Valid Grade grade, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }
}
