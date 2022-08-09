package com.lms.Application.dao;

import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
}
