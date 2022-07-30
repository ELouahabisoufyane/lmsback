package com.lms.Application.dao;

import com.lms.Application.entities.Etudiant;
import com.lms.Application.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    @Query("select c from Etudiant c where c.username like :x")
    Page<Etudiant> chercher(@Param("x")String mc, Pageable pageable);
}
