package grade.example.grade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class GradeController {

    @GetMapping("grades")
    public String getGrades(Model model) {
        Grade grade = new Grade("HARRY","POTIONS","C-");
        model.addAttribute(attributeName: "grade", grade);
        return "shows";
    }
    
}
