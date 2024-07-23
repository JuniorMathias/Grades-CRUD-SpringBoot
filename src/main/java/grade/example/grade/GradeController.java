package grade.example.grade;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GradeController {

    List<Grade> studentsGrades = Arrays.asList(
        new Grade("HARRY", "POTIONS", "C-"),
        new Grade("Kane", "TOP", "A-"),
        new Grade("JASON", "MAMOA", "B+")
    );

    @GetMapping("/")
    public String gradesForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @GetMapping("/grades")
    public String newProductForm(Model model) {
        model.addAttribute("grades", studentsGrades);
        return "grades";
    }
}

