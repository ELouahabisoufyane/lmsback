package com.lms.Application.service;

import com.lms.Application.dao.ProfesseurRepository;
import com.lms.Application.dao.UserRepository;
import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.User;
import com.lms.Application.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository cltRep;
    @Autowired
    private ProfesseurRepository pr;

    @Override
    public List<User> getUsers() {
        return cltRep.findAll();
    }

    @Override
    public User getUser(String code) {
        try {
            return cltRep.findByUserName(code);
        } catch (Exception e) {return null;}
    }




    @Override
    public Professeur saveUser(Professeur frs) {
        return pr.save(frs);
    }

    @Override
    public void deleteUser(Long id) {
        cltRep.deleteById(id);

    }

    @Override
    public Page<User> getUsers(int page, int size) {
        return cltRep.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<User> getUsersByMotCle(String mc, int page, int size) {
        return cltRep.findAllByMotCle(mc, PageRequest.of(page, size));
    }
}
