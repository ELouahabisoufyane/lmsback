package com.lms.Application.service;

import com.lms.Application.dao.RoleRepository;
import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.Role;
import com.lms.Application.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository rr;
    public Page<Role> getRoless(int page) {
        return rr.findAll(PageRequest.of(page, 3));
    }
    public Role saveRole(Role r) {


        return rr.save(r);
    }
    public Role getRole(){
        return rr.findByRole("prof");
    }
}
