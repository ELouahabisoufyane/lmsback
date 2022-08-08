package com.lms.Application.dao;

import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiplomeRepository extends JpaRepository<Diplome,Long> {
}
