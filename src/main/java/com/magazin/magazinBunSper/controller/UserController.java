package com.magazin.magazinBunSper.controller;
import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<User> getUserById(@PathVariable long id)  {
        return new ResponseEntity<>(userService.findById2(id), HttpStatus.OK);}


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllEmployees () {
        List<User> employees = userService.findAllOrders();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        User employee = userService.findById2(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<User> addUsers (@RequestBody User user) {
        User newUser = userService.addUser(user);
        System.out.println(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @PutMapping("/update/name")
    public ResponseEntity<User> updateUserName(@RequestBody User user, @RequestParam String nume) {
        User updateUser = userService.updateUserNume(user,nume);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @PutMapping("/update/email")
    public ResponseEntity<User> updateUserEmail(@RequestBody User user, @RequestParam String email) {
        User updateUser = userService.updateUserNume(user,email);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @PutMapping("/update/varsta")
    public ResponseEntity<User> updateUserVarsta(@RequestBody User user, @RequestParam Integer varsta) {
        User updateUser = userService.updateUserVarsta(user,varsta);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @PutMapping("/update/prenuma")
    public ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam String prenume) {
        User updateUser = userService.updateUserPrenume(user, prenume);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}