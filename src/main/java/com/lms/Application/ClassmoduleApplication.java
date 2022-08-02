package com.lms.Application;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.dao.RoleRepository;
import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassmoduleApplication    {


	public static void main(String[] args) {
		SpringApplication.run(ClassmoduleApplication.class, args);
	}



}
