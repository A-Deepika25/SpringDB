package com.springboot.SpringBootMongodb;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public User saveUser(User user);
    public List<User> getUser();
    public ResponseEntity<User> getUserById(Long id);
    public User updateUser(Long id,User user);
    public  void deleteUser(Long id);

}
