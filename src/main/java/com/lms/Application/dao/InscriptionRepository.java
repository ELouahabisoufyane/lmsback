package com.lms.Application.dao;

import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
}
