package com.lms.Application;
import com.lms.Application.dao.DiplomeRepository;
import com.lms.Application.dao.FiliereRepository;
import com.lms.Application.dao.ProfesseurRepository;
<<<<<<< HEAD
import com.lms.Application.entities.Diplome;
import com.lms.Application.entities.Filiere;
=======
import com.lms.Application.dao.RoleRepository;
>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578
import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
import java.util.ArrayList;

@SpringBootApplication
public class ClassmoduleApplication implements CommandLineRunner {
	private final DiplomeRepository DR;
	private final FiliereRepository FR;
	public ClassmoduleApplication(DiplomeRepository pr,FiliereRepository fr) {
		this.DR = pr;
		this.FR=fr;
	}
=======
@SpringBootApplication
public class ClassmoduleApplication    {


>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578
	public static void main(String[] args) {
		SpringApplication.run(ClassmoduleApplication.class, args);
	}

<<<<<<< HEAD
	@Override
	public void run(String... args) throws Exception {
          Diplome m=new Diplome();
		  m.setTypeDiplome("Master");
		  Filiere f1=new Filiere();
		  f1.setTitre("data");
		  f1=FR.save(f1);
		Filiere f2=new Filiere();
		f2.setTitre("MATH");
		f2=FR.save(f2);
		  m=DR.save(m);
		  m.addFiliere(f1);
		  m.addFiliere(f2);DR.save(m);
		  FR.save(f1);
		FR.save(f2);
	}
=======


>>>>>>> b4c111947e63a25d9bb8b56fbe2cca60270bf578
}
