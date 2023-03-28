package com.magazin.magazinBunSper.ServiceTest;

import com.magazin.magazinBunSper.model.Product;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.repository.UserRepository;
import com.magazin.magazinBunSper.service.UserService;
import com.magazin.magazinBunSper.service.serviceImplementation.AdminServiceImplementation;
import com.magazin.magazinBunSper.service.serviceImplementation.UserServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class UserServiceTests {

    private UserService userService;
    @Mock
    private UserRepository userRepository;


    private boolean verificaDelete=false;
    private User user;
    private String NameUser = "Boca";
    private int idToFind=2;

    private int idToFindNot=1;
    private String NameUser_NOT="Doesn't exist";


    @BeforeEach
    void init() {
        initMocks(this);
        userService = new UserServiceImplementation(userRepository);
        user = new User();
        user.setId(idToFind);
        when(userService.findUserById2(idToFind)).thenReturn(Optional.of(user));
    }

    @Test
    void givenExistingUser_whenFindById_thenFindOne() {
        userService = new UserServiceImplementation(userRepository);
        when(userService.findUserById2(idToFind)).thenReturn(Optional.of(user));
        Optional<User> userFound = userService.findUserById2(idToFind);
        assertNotNull(userFound);
        assertEquals(2, userFound.get().getId());
    }

    @Test
    void givenNonExistingUser_whenFindById_thenThrowException() {
        when(userService.findUserById2(idToFindNot)).thenReturn(Optional.empty());

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            userService.findUserById2(idToFindNot).get();

        }, "No user to delete");
    }

    @Test
    void whenAddingUser_thenReturnMeUser() {
        userService = new UserServiceImplementation(userRepository);
        when(userService.addUser(user)).thenReturn(user);
        assertNotNull(user);
    }

    @Test
    void whenTryingDeleteUser()
    {
        userService=new UserServiceImplementation(userRepository);
        assertNotNull(user);
        userService.deleteUser(user);
    }

    @Test
    void givenAnExistingId_whenTryingToDelete() {
        userService = new UserServiceImplementation(userRepository);
        userService.deleteUserById(idToFind);
    }

//    @Test
//    void givingName_whenTryingToFind_thenReturnUseer()
//    {
//        userService=new UserServiceImplementation(userRepository);
//        when(userService.fetchAUserByName(NameUser)).thenReturn(user);
//        user=userService.fetchAUserByName(NameUser);
//        assertNotNull(user);
//    }

    @Test
    void whenUpdatingClientNume_thenProductIsUpdated() {
        userService=new UserServiceImplementation(userRepository);
        User originalUser = new User();
        originalUser.setId(1);
        originalUser.setNumeClient("Boca");
        when(userRepository.findById(originalUser.getId())).thenReturn(Optional.of(originalUser));
        User originalUser2 = userService.updateUserNume(originalUser, NameUser);
        assertEquals(NameUser, originalUser2.getNumeClient());

    }





}
