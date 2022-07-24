package com.lms.Application.dao;

import com.lms.Application.entities.Classe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    @Query("select c from Classe c where c.name like :x")
    Page<Classe> chercher(@Param("x")String mc, Pageable pageable);

}
