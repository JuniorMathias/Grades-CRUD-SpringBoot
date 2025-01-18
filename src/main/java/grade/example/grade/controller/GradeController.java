package grade.example.grade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import grade.example.grade.Constants;
import grade.example.grade.Grade;
import grade.example.grade.repository.GradeRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class GradeController {

   GradeRepository gradeRepository = new GradeRepository();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
       int gradeIndex = getGradeIndex(id);
        model.addAttribute("grade", gradeIndex == Constants.NOT_FOUND 
            ? new Grade() 
            : gradeRepository.getGrade(gradeIndex));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        System.out.println("Has errors?:" + result.hasErrors());
       if (result.hasErrors()) return "form";
        int index = getGradeIndex(grade.getId());
        if(index == Constants.NOT_FOUND) {
           gradeRepository.addGrade(grade);
        }else{
            gradeRepository.updateGrade(grade, index);
        }
        return "redirect:/grades";
    }
    

    @GetMapping("/grades")
    public String newProductForm(Model model) {
        model.addAttribute("grades", gradeRepository.getGrades());
        return "grades";
    }

    public Integer getGradeIndex(String id){
        for( int i = 0; i < gradeRepository.getGrades().size(); i++){
            if(gradeRepository.getGrades().get(i).getId().equals(id)){
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }
}

