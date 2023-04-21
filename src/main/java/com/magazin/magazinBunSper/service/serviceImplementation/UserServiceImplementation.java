package com.magazin.magazinBunSper.service.serviceImplementation;

import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.OrderRepository;
import com.magazin.magazinBunSper.repository.UserRepository;
import com.magazin.magazinBunSper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
  //  private List<User> usersList;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(Integer id)
    {
        userRepository.deleteUserById(id);
    }

    @Override
    public List<User> findAllOrders()
    {
        return (List<User>) userRepository.findAll();
    }


    @Override
    public Optional<User> findUserById2(Integer id)
    {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user1)
    {
        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(User user1)
    {
        userRepository.delete(user1);
    }

    @Override
    public boolean deleteUserById(Integer id)
    {
        userRepository.deleteById(id);
        return false;
    }

    @Override
    public User fetchAUserByName(String name) {
        ArrayList<User> usersList = (ArrayList<User>) findAllOrders();
        for (User user : usersList) { // assuming adminList is a List<Admin> that holds all Admin objects
            if (user.getNumeClient().equals(name)) {
                return user;
            }
        }
        return null; // Admin not found
    }

    @Override
    public User updateUserEmail(User product, String email) {
        User updateUser = userRepository.findById(product.getId()).get();
        updateUser.setAdresaEmail(email);
        userRepository.save(updateUser);

        return updateUser;
    }
    @Override
    public User updateUserNume(User product, String nume) {
        User updateUser = userRepository.findById(product.getId()).get();
        updateUser.setNumeClient(nume);
        userRepository.save(updateUser);

        return updateUser;
    }
    @Override
    public User updateUserPrenume(User product, String prenume) {
        User updateUser = userRepository.findById(product.getId()).get();
        updateUser.setPrenumeClient(prenume);
        userRepository.save(updateUser);

        return updateUser;
    }
    @Override
    public User updateUserVarsta(User product, int varsta) {
        User updateUser = userRepository.findById(product.getId()).get();
        updateUser.setVarsta(varsta);
        userRepository.save(updateUser);

        return updateUser;
    }
    @Override
    public User updateUserParola(User product, String parola) {
        User updateUser = userRepository.findById(product.getId()).get();
        updateUser.setParola(parola);
        userRepository.save(updateUser);

        return updateUser;
    }

    @Override
    public User findById2(Long id) {
        Optional<User> userOptional = userRepository.findById(Math.toIntExact(id));
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new NoSuchElementException("User not found with id " + id);
        }
    }

    @Override
    public String logInClient(User user, String parola, String email)
    {
        User user1=userRepository.findById(user.getId()).orElse(null);
        if(user.getParola().equals(parola) && user.getAdresaEmail().equals(email))
            return  "Logarea  clientului a avut loc cu succes";
        else
            return "Logarea nu a a putut avea loc! Mai incercati";
    }



//    public User findById(Long id) {
//        // implementation depends on your specific use case and data access mechanism
//        User user = userRepository.findById(id);
//        return user; // may be null if no user is found
//    }


    //Userul are acces si la orders deoarece el poate sa isi dea update la cosul de c


    //daca comanda are acelasi user ca si
//    @Override
//    public Orderer updateOrder(Orderer order, User user1) {
//        if (order.getUser().getId() == user1.getId())
//        {
//            order.setComanda();
//        }
//
//        return order;
//    }

}
