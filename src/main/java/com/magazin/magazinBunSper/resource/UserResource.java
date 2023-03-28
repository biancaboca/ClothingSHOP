package com.magazin.magazinBunSper.resource;

import com.magazin.magazinBunSper.model.User;
import com.magazin.magazinBunSper.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<User>> getAllUsers () {
//        List<User> users = userService.;
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//    @GetMapping("/find/{id}")
//    public ResponseEntity<User> getUserById (@PathVariable("id") Integer id) {
//        Optional<User> user = userService.findUserById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User updateEmployee = userService.(employee);
//        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        userService.deleteUser(Math.toIntExact(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
