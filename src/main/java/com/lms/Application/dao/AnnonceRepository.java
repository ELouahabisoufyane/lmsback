package com.lms.Application.dao;

import com.lms.Application.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
}
