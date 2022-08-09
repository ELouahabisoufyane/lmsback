package com.lms.Application.dao;

import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
