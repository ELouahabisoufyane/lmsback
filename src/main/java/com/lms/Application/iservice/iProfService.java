package com.lms.Application.iservice;

import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface iProfService {
    public List<Professeur> getProfs();
    public Page<Professeur> getPageProfs(int page, int size);
    public Page<Professeur> getProfsByMotCle(String mc,int page, int size);
    public Professeur getProf( String username );
    public Professeur saveProf(Professeur u);
    public void deleteProf(Long id);
}

