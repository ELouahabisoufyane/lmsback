package com.lms.Application.service;
import com.lms.Application.dao.ClasseRepository;
import com.lms.Application.entities.Classe;
import com.lms.Application.iservice.IClasseServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@Service
@Transactional
public class ClasseService implements IClasseServices {

    ClasseRepository cr;
    @Autowired
    public ClasseService( ClasseRepository cr){
        this.cr=cr;
    }

    @Override
    public List<Classe> getAllClasses() {
        return cr.findAll();
    }

    @Override
    public Classe findClassbyId(Long id) {
        return cr.findById(id).get();
    }

    @Override
    public Classe updateClass(Classe c) {
        return cr.save(c);

    }

    @Override
    public void deleteClass(Long id) {
        cr.deleteById(id);

    }

    @Override
    public Classe addClass(Classe c) {
        cr.save(c);
        return c;
    }

    @Override
    public Page<Classe> chercherClass(String mc, int page, int size) {
        return cr.chercher("%"+mc+"%",PageRequest.of(page,size,Sort.by("id") ) );
    }
    public Page<Classe> findPage(int pageNumber){

       return cr.findAll(PageRequest.of(pageNumber,6));
    }
}
