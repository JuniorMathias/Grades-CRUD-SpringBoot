package grade.example.grade;

import org.springframework.boot.SpringApplication;

public class TestGradeApplication {

	public static void main(String[] args) {
		SpringApplication.from(GradeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
