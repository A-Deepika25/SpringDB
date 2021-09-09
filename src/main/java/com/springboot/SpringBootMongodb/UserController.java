package com.springboot.SpringBootMongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }
    @GetMapping("/list")
    public List<User> getUser() {
        return userService.getUser();
    }
    @GetMapping("/list/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable("user_id") Long id) {
        return userService.getUserById(id);
  }
    @PutMapping("/update/{user_id}")
    public User updateUser(@RequestBody User user,@PathVariable("user_id") long id){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/delete/{user_id}")
    public String deleteUser(@PathVariable("user_id") long id){
        userService.deleteUser(id);
        return "Deleted Successfully.";
    }
    }
