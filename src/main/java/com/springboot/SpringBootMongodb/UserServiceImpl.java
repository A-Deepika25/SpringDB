package com.springboot.SpringBootMongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }
    @Override
    public ResponseEntity<User> getUserById(@PathVariable("user_id") Long id) {
        Optional<User> Data = userRepository.findById(id);

        if (Data.isPresent()) {
            return new ResponseEntity<>(Data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public User updateUser(Long id, User user) {
        Optional<User> findById = userRepository.findById(id);
        if(findById.isPresent()){
            User userEntity = findById.get();
            if(user.getName() !=null && !user.getName().isEmpty())
                userEntity.setName(user.getName());
            if(user.getAge()!=null)
                userEntity.setAge(user.getAge());
            return userRepository.save(userEntity);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
