package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class Seminar6Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Spring1Application.class, args);
		
	}
	@Bean
	public CommandLineRunner testDatabaseLayer(IStudentRepo studRepo, 
			IProfessorRepo profRepo, ICourseRepo courseRepo, IGradeRepo gradeRepo) {
				return new CommandLineRunner() {
					
					@Override
					public void run(String... args) throws Exception {
						// TODO Auto-generated method stub
						Professor p1 = new Professor("Janis", "Berzins", Degree.bsc);
						Professor p2 = new Professor("Karlis", "Lielais", Degree.phd);
						profRepo.save(p1);
						profRepo.save(p2);
						
						Student s1 = new Student("Zigis", "Brivais");
						Student s2 = new Student("Muris", "Buncis");
						studRepo.save(s1);
						studRepo.save(s2);
						
						Course c1 = new Course("JAVA", 4, p1);
						Course c2 = new Course("Math", 2, p2);
						courseRepo.save(c1);
						courseRepo.save(c2);
						
						Grade gr1 = new Grade(c1, s1, 7);
						Grade gr2 = new Grade(c2, s2, 9);
						gradeRepo.save(gr1);
						gradeRepo.save(gr2);
						
					}
				};
		
	}
}
