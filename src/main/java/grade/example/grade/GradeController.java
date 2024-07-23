package grade.example.grade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String gradeForm(Model model) {
        model.addAttribute("grade",  new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        studentsGrades.add(grade);
        return "redirect:/grades";
    }
    

    @GetMapping("/grades")
    public String newProductForm(Model model) {
        model.addAttribute("grades", studentsGrades);
        return "grades";
    }
}

