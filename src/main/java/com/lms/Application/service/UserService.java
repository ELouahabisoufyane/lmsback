package com.lms.Application.service;

import com.lms.Application.dao.UserRepository;
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
    public User saveUser(User frs) {
        return cltRep.save(frs);
    }

    @Override
    public boolean deleteUser(String code) {
        User frs = cltRep.findByUserName(code);
        if(frs!=null) {
            cltRep.delete(frs);
            return true;
        }
        return false;
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
