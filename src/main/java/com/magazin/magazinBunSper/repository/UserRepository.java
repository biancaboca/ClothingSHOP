package com.magazin.magazinBunSper.repository;

import com.magazin.magazinBunSper.model.User;
import jakarta.persistence.Entity;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
   // Optional findUserById(Long id);

    void deleteUserById(Integer id);

//    User findById(Long id);
//    List<User> findAllUsers();
//    void deleteUser(Integer id);
//    User findUserById(Long id);
//    User addUser(User user1);
//    void deleteUser(User user1);
//    User fetchAUserByName(String name);

}
