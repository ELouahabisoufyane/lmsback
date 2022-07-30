package com.lms.Application;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.entities.Professeur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassmoduleApplication   {
	private final ProfesseurRepository pr;

	public ClassmoduleApplication(ProfesseurRepository pr) {
		this.pr = pr;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClassmoduleApplication.class, args);
	}


}
