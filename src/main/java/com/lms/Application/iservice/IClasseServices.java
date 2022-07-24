package com.lms.Application.iservice;

import com.lms.Application.entities.Classe;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IClasseServices {
     List<Classe> getAllClasses();
     Classe findClassbyId(Long id);
     Classe updateClass(Classe c);
    void deleteClass(Long id);
    Classe addClass(Classe c);
     Page<Classe> chercherClass(String mc, int page, int size);


}
