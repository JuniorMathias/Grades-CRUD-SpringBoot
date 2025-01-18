package grade.example.grade.repository;

import java.util.ArrayList;
import java.util.List;

import grade.example.grade.Grade;



public class GradeRepository {
    private List<Grade> studentsGrades = new ArrayList<>();

    public Grade getGrade(int index){
        return studentsGrades.get(index);
    }

    public void addGrade(Grade grade){
        studentsGrades.add(grade);
    }

    public void updateGrade(Grade grade, int index){
        studentsGrades.set(index, grade);
    }

    public List<Grade> getGrades(){
        return studentsGrades;
    }
}
