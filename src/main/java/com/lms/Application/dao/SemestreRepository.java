package com.lms.Application.dao;

import com.lms.Application.entities.Classe;
import com.lms.Application.entities.Module;
import com.lms.Application.entities.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {

    @Query("select m from Module m where m.semestre.id=:x")
    Page<Module> findAllModules(@Param("x")Long id, Pageable pageable);
}
