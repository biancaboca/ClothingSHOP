package com.magazin.magazinBunSper.service.serviceImplementation;

import com.magazin.magazinBunSper.model.Admin;
import com.magazin.magazinBunSper.model.Orderer;
import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.AdminRepository;
import com.magazin.magazinBunSper.repository.OrderRepository;
import com.magazin.magazinBunSper.repository.ProductRepository;
import com.magazin.magazinBunSper.repository.UserRepository;
import com.magazin.magazinBunSper.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.valueOf;

@Service
public class AdminServiceImplementation implements AdminService {
    List<Admin> listAdmin;

    @Autowired
    private  AdminRepository adminRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    public AdminServiceImplementation(AdminRepository adminRepository, ProductRepository productRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.adminRepository = adminRepository;
        this.productRepository=productRepository;
        this.orderRepository=orderRepository;
        this.userRepository=userRepository;
    }

    //metode pentru admin

    @Override
    public List<Admin> findAllAdmins()
    {
        return (List<Admin>) adminRepository.findAll();
    }
    @Override
        public Admin addAdmin(Admin Admin1)
        {
            return adminRepository.save(Admin1);
        }
    @Override
        public void deleteAdmin(Admin Admin1)
        {
            adminRepository.delete(Admin1);
        }
    @Override
    public void deleteAdminById(Integer id)
    {
        adminRepository.deleteById(id);
    }
    @Override
    public Optional<Admin> findAdminById(Integer id)
    {
        return adminRepository.findById(valueOf(id));
    }

    @Override
    public Admin fetchAdminByName(String name) {
        for (Admin admin : listAdmin) { // assuming adminList is a List<Admin> that holds all Admin objects
            if (admin.getName().equals(name)) {
                return admin;
            }
        }
        return null; // Admin not found
    }


    @Override
    public Admin verifiingAdmin(Admin admin)
    {
        Admin adminDeVerificat=adminRepository.findById(admin.getId()).orElse(null);
        return adminDeVerificat;
    }

    @Override
    public String logIn(Admin admin1, String parola, int codAdmin)
    {
        Admin adminToLogin=adminRepository.findById(admin1.getId()).orElse(null);
        if(adminToLogin.getParola().equals(parola) && adminToLogin.getCodAdmin()==codAdmin)
            return  "Logarea a avut loc cu succes";
        else
            return "Logarea nu a a putut avea loc! Mai incercati";
    }



}
