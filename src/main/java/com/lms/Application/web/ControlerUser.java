package com.lms.Application.web;

import com.lms.Application.dao.UserRepository;
import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.User;
import com.lms.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class ControlerUser {
    @Autowired
    private final UserService us;
    private final UserRepository ur;
    public ControlerUser(UserService us, UserRepository ur) {
        this.us = us;
        this.ur = ur;
    }


    @GetMapping("/list/{p}")
    public Page<User> showPage(@PathVariable("p") int currentPage){
        Page<User> page = us.getUsers(currentPage,7);
        return page;
    }
    @PostMapping("/add")

    public ResponseEntity<User> addUser(@RequestBody Professeur cl) {
        User newuser=us.saveUser(cl);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody   Professeur u){
        return us.saveUser(u);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id")  Long id){
        us.deleteUser(id);
    }
    @PostMapping("/login")
    User login(@RequestBody User u){
        return ur.findByUsernameAndPassword(u.getUsername(),u.getPassword());
    }

}
