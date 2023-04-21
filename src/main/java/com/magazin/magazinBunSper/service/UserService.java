package com.magazin.magazinBunSper.service;

import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {


    void deleteUser(Integer id);
    List<User> findAllOrders();
    Optional<User> findUserById2(Integer id);
    User addUser(User user1);
    void deleteUser(User user1);
    boolean deleteUserById(Integer id);
    User fetchAUserByName(String name);
    User updateUserEmail(User product, String email);
    User updateUserNume(User product, String nume);
    User updateUserPrenume(User product, String prenume);
    User updateUserVarsta(User product, int varsta);
    User updateUserParola(User product, String parola);
    User findById2(Long id);
    String logInClient(User user, String parola, String email);

}
