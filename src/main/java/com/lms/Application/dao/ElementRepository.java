package com.lms.Application.dao;

import com.lms.Application.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element,Long> {
}
