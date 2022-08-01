package com.lms.Application.dao;

import com.lms.Application.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
}
