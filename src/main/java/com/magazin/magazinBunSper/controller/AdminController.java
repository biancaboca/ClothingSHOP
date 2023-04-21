package com.magazin.magazinBunSper.controller;

import com.magazin.magazinBunSper.model.Admin;
import com.magazin.magazinBunSper.service.AdminService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService ;
    public AdminController(AdminService adminService)
    {
        this.adminService=adminService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable Integer id)  {
        return new ResponseEntity<>(adminService.findAdminById(id), HttpStatus.OK);}

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAdmins () {
        List<Admin> admins = adminService.findAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Admin>> findAdminById (@PathVariable("id") Integer id) {
        Optional<Admin> admin = adminService.findAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin (@RequestBody Admin admin) {
        Admin admin2 = adminService.addAdmin(admin);
        return new ResponseEntity<>(admin2, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdminById(@PathVariable("id") Integer id) {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @DeleteMapping("/delete/admin")
//    public ResponseEntity<?> deleteAdmin(@PathVariable("id") Admin admin) {
//        adminService.deleteAdmin(admin);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
