package com.lms.Application.service;

import com.lms.Application.dao.AdminRepository;
import com.lms.Application.dao.RoleRepository;
import com.lms.Application.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private final AdminRepository er;
    @Autowired
    private final RoleRepository r;
    public AdminService(AdminRepository er, RoleRepository r) {
        this.er = er;
        this.r = r;
    }


    public Page<Admin> findPage(int pageNumber){

        return er.findAll(PageRequest.of(pageNumber,6));
    }
    public Admin findAdminbyId(Long id) {
        return er.findById(id).get();
    }


    public Admin updateAdmin(Admin c) {
        return er.save(c);

    }


    public void deleteAdmin(Long id) {
        er.deleteById(id);

    }


    public Admin addAdmin(Admin c,String role) {
        c.addRole( r.findByRole(role));
        er.save(c);

        return c;
    }


    public Page<Admin> chercherAdmin(String mc, int page, int size) {
        return er.chercher("%"+mc+"%",PageRequest.of(page,size, Sort.by("id") ) );

    }
    public Long getcard(){
        return er.count();
    }
}
