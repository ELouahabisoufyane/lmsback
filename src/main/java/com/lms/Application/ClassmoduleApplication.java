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
          Diplome m=new Diplome();
		  m.setTypeDiplome("Master");
		  m.setIndece(2);
		  Filiere f1=new Filiere();
		  f1.setTitre("data");
		  f1=FR.save(f1);
		Filiere f2=new Filiere();
		f2.setTitre("MATH");
		f2=FR.save(f2);
		  m=DR.save(m);

		  DS.addFiliere(f1,m.getId());
		  DS.addFiliere(f2,m.getId());
          Promotion p=new Promotion();
		  fs.addPromotion(p,f1.getId());




		/*Module mo=new Module();
		mo.setTitre("java");
		Module moo=new Module();
		moo.setTitre("java");
		Professeur p=new Professeur();
		p.setUsername("ahmed");
		p.setCin("z1111");
		p=PR.save(p);
		ps.affecterModule(moo,p.getId());
		p=PR.findById(p.getId()).get();
		System.out.println(p.getModules().size());*/
	}

}
