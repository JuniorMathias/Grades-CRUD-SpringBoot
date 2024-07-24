package grade.example.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String gradeForm(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("grade", 
            getGradeIndex(name) == -1000 
            ? new Grade() 
            : studentsGrades.get(getGradeIndex(name)));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        int index = getGradeIndex(grade.getName());
        if(index == -1000) {
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

    public Integer getGradeIndex(String name){
        for( int i = 0; i < studentsGrades.size(); i++){
            if(studentsGrades.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1000;
    }
}

