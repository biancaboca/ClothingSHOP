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

    //metode pentru Admins
    List<Admin> findAllAdmins();
    Optional<Admin> findAdminById(Integer id);
    Admin addAdmin(Admin Admin1);
    void deleteAdmin(Admin Admin1);
    void deleteAdminById(Integer id);
    Admin fetchAdminByName(String name);

    //metode pentru Order

    Orderer addOrder(Orderer order1);
    void deleteOrder(Orderer order1);
    void deleteOrderById(Integer id);
    List<Orderer> findAllOrders();


    //metode pentru user

    Optional<User> findUserById(Integer id);
    User addUser(User user1);
    void deleteUser(User user1);
    void deleteUserById(Integer id);
    List<User> findAllUsers();


    //metode pentru Product
    List<Product> findAllProducts();
    Optional<Product> findProductById(Integer id);
    Product addProduct(Product Product1);
    void deleteProduct(Product Product1);
    void deleteProductById(Integer id);
    Product updateProduct(Product product);

    Product updateProductByName(Product product, String numeProdus);

    Product updateProduct(Product product, String marca);

    Product updateProduct(Product product, int cantitate);

    Product updateProductPret(Product product, int pret);

    Admin verifiingAdmin(Admin admin);

    String logIn(Admin admin1, String parola, int codAdmin);
}

