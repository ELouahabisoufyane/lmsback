package com.lms.Application.dao;

import com.lms.Application.entities.Etudiant;
import com.lms.Application.entities.Filiere;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FiliereRepository extends JpaRepository<Filiere,Long> {
    @Query("select c from Filiere c where c.titre like :x")
    Page<Filiere> chercher(@Param("x")String mc, Pageable pageable);
}
