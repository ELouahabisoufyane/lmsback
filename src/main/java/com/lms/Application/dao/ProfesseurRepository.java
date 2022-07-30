package com.lms.Application.dao;

import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    @Query("select c from Professeur c where c.username like :x")
    Page<Professeur> chercher(@Param("x")String mc, Pageable pageable);


    Professeur findByUsername(String name);
}
