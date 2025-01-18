package grade.example.grade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import grade.example.grade.Grade;
import grade.example.grade.service.GradeService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class GradeController {

   GradeService gradeService = new GradeService();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
       model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        System.out.println("Has errors?:" + result.hasErrors());
       if (result.hasErrors()) return "form";
       gradeService.submitGrade(grade);
        return "redirect:/grades";
    }
    

    @GetMapping("/grades")
    public String newProductForm(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

  
}

