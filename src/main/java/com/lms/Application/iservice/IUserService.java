package com.lms.Application.iservice;

import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    public Page<User> getUsers(int page, int size);
    public Page<User> getUsersByMotCle(String mc,int page, int size);
    public User getUser( String username );
    public  Professeur saveUser( Professeur u);
    public void deleteUser(Long id);
}
