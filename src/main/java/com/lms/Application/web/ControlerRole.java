package com.lms.Application.web;

import com.lms.Application.entities.Professeur;
import com.lms.Application.entities.Role;
import com.lms.Application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/role")
public class ControlerRole {
    @Autowired
    RoleService rs;
    @GetMapping("/list/{p}")
    public Page<Role> showPage(@PathVariable("p") int currentPage){
        Page<Role> page = rs.getRoless(currentPage);
        return page;
    }
    @PostMapping("/add")

    public Role addProfesseur(@RequestBody Role r) {
        Role  newrole=rs.saveRole(r);
        return newrole;
    }
    @GetMapping("/get")

    public Role getProfesseur() {
        Role  newrole=rs.getRole();
        return newrole;
    }

}
