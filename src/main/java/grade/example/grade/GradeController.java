package grade.example.grade;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GradeController {

    @GetMapping("/shows")
    public String getGrades(Model model) {
        Grade grade = new Grade("HARRY", "POTIONS", "C-");
        model.addAttribute("grade", grade);
        return "shows";
    }

    @GetMapping("/grades")
    public String newProductForm(Model model) {
        Grade grade = new Grade("HARRY", "POTIONS", "C-");
        model.addAttribute("grade", grade);
        return "grades";
    }
}

