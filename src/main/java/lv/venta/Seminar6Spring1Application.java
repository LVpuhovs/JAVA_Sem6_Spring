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
						Professor pr1 = new Professor("Marcis", "Naktins", Degree.mg);
						Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
						Professor pr3 = new Professor("Arturs", "Orbidans", Degree.mg);
						profRepo.save(pr1);
						profRepo.save(pr2);
						profRepo.save(pr3);
						
						Student s1 = new Student("Zigis", "Brivais");
						Student s2 = new Student("Muris", "Buncis");
						studRepo.save(s1);
						studRepo.save(s2);
						
						Course c1 = new Course("Programesana timekli JAVA", 4, pr2);
						Course c2 = new Course("Operetajsistemas", 2, pr1, pr3);
						Course c3 = new Course("Datu strukturas", 2, pr2);
						courseRepo.save(c1);
						courseRepo.save(c2);
						courseRepo.save(c3);
						
						pr2.addCourse(c1);//Karinai piesaistām JAVA
						pr2.addCourse(c3);//Karinai piesaistām DataSTR
						profRepo.save(pr2);
						
						pr1.addCourse(c2);//Naktiņam piesaistām Opersis
						profRepo.save(pr1);
						
						pr3.addCourse(c2);//Orbidānam piesaistam Opersis
						profRepo.save(pr3);
						
						c1.addProfessor(pr2);
						c2.addProfessor(pr1);
						c2.addProfessor(pr3);
						c3.addProfessor(pr2);
						courseRepo.save(c1);
						courseRepo.save(c2);
						courseRepo.save(c3);
						
				
						
						Grade gr1 = new Grade(c1, s1, 7);
						Grade gr2 = new Grade(c2, s2, 9);
						Grade gr3 = new Grade(c1, s1, 3);
						Grade gr4 = new Grade(c2, s2, 6);
						gradeRepo.save(gr1);
						gradeRepo.save(gr2);
						gradeRepo.save(gr3);
						gradeRepo.save(gr4);
					}
				};
		
	}
}
