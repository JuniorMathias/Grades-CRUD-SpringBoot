package grade.example.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class GradeController {

    List<Grade> studentsGrades = new ArrayList<>();
    // List<Grade> studentsGrades = Arrays.asList(
    //     new Grade("HARRY", "POTIONS", "C-"),
    //     new Grade("Kane", "TOP", "A-"),
    //     new Grade("JASON", "MAMOA", "B+")
    // );

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
       int gradeIndex = getGradeIndex(id);
        model.addAttribute("grade", 
            gradeIndex == Constants.NOT_FOUND 
            ? new Grade() 
            : studentsGrades.get(gradeIndex));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        System.out.println("Has errors?:" + result.hasErrors());
       if (result.hasErrors()) return "form";
        int index = getGradeIndex(grade.getId());
        if(index == Constants.NOT_FOUND) {
            studentsGrades.add(grade);
        }else{
            studentsGrades.set(index, grade);
        }
        return "redirect:/grades";
    }
    

    @GetMapping("/grades")
    public String newProductForm(Model model) {
        model.addAttribute("grades", studentsGrades);
        return "grades";
    }

    public Integer getGradeIndex(String id){
        for( int i = 0; i < studentsGrades.size(); i++){
            if(studentsGrades.get(i).getId().equals(id)){
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }
}

