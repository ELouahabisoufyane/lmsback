package com.lms.Application.dao;

import com.lms.Application.entities.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RessourceRepository extends JpaRepository<Ressource, String> {


}
