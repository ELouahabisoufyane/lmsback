package com.lms.Application.service;

import com.lms.Application.dao.SemestreRepository;
import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SemestreService {
    private final SemestreRepository sr;


    public SemestreService(SemestreRepository sr) {
        this.sr = sr;
    }

    public Page<Module> findPageModules(Long id,int pageNumber){

        return sr.findAllModules(id,PageRequest.of(pageNumber,3));
    }
}
