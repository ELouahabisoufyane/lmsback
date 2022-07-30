package com.lms.Application.web;

import com.lms.Application.entities.Admin;
import com.lms.Application.entities.Etudiant;
import com.lms.Application.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins ="*" )
public class ControlerAdmin {
    @Autowired
    private final AdminService es;

    public ControlerAdmin(AdminService es) {
        this.es = es;
    }


    @GetMapping("/list/{p}")
    public Page<Admin> showPage(@PathVariable("p") int currentPage){
        Page<Admin> page = es.findPage(currentPage);
        return page;
    }
    @PostMapping("/add/{role}")

    public Admin addAdmin(@RequestBody Admin cl,@PathVariable("role") String role) {

        Admin newuser=es.addAdmin(cl,role);
        return newuser;
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody   Admin u){

        return es.updateAdmin(u);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable("id")  Long id){

        es.deleteAdmin(id);
    }
    @GetMapping("/chercher")
    public  Page<Admin> chercherAdmin(@RequestParam(name = "mc",defaultValue = "i") String mc,
                                            @RequestParam(name = "page",defaultValue = "0") int page,
                                            @RequestParam(name = "size",defaultValue = "4") int size) {
        Page<Admin> p=es.chercherAdmin(mc,page,size) ;

        return p;
    }
    @GetMapping("/findbyid/{id}")
    public Admin findAdminbyId(@PathVariable("id") Long id) {
        Admin p=es.findAdminbyId(id);
        return p;
    }
    @GetMapping("/card")
    public Long card() {
        return  es.getcard();

    }
}
