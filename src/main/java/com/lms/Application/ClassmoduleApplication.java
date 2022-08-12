package com.lms.Application;
import com.lms.Application.dao.DiplomeRepository;
import com.lms.Application.dao.FiliereRepository;
import com.lms.Application.dao.ModuleRepository;
import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.entities.*;
import com.lms.Application.entities.Module;
import com.lms.Application.service.DiplomeService;
import com.lms.Application.service.FiliereService;
import com.lms.Application.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ClassmoduleApplication implements CommandLineRunner {
	private final DiplomeRepository DR;
	private final FiliereRepository FR;
	private final ProfesseurRepository PR;
	private final ModuleRepository MR;
	@Autowired
	FiliereService fs;
	@Autowired
	DiplomeService DS;
	@Autowired
	ModuleRepository mr;
	public ClassmoduleApplication(DiplomeRepository pr, FiliereRepository fr, ProfesseurRepository mr, ModuleRepository mr1) {
		this.DR = pr;
		this.FR=fr;
		PR = mr;
		MR = mr1;
	}



	public static void main(String[] args) {
		SpringApplication.run(ClassmoduleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
