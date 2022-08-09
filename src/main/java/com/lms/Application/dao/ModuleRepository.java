package com.lms.Application.dao;

import com.lms.Application.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module,Long> {
}
