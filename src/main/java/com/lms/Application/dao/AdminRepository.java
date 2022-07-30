package com.lms.Application.dao;

import com.lms.Application.entities.Admin;
import com.lms.Application.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query("select c from Admin c where c.username like :x")
    Page<Admin> chercher(@Param("x")String mc, Pageable pageable);
}
