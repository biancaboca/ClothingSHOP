package com.magazin.magazinBunSper.service;

import com.magazin.magazinBunSper.model.Admin;
import com.magazin.magazinBunSper.model.Orderer;
import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.AdminRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public interface AdminService {

    List<Admin> findAllAdmins();
    Optional<Admin> findAdminById(Integer id);
    Admin addAdmin(Admin Admin1);
    void deleteAdmin(Admin Admin1);
    void deleteAdminById(Integer id);
    Admin fetchAdminByName(String name);
    Admin verifiingAdmin(Admin admin);
    String logIn(Admin admin1, String parola, int codAdmin);
}

