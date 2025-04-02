package com.example.crud.service;

import com.example.crud.repository.User;
import com.example.crud.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;


@Service //this annotation is used to indicate that class belongs to the service layer in an app
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }
        user.setAge(Period.between(user.getBirthday(), LocalDate.now()).getYears());
        return userRepository.save(user);
    }


    public void delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User with " + id + " id not found");
        }else{
            userRepository.deleteById(id);
        }

    }
    @Transactional//this annotation giving us do transaction without userRep.save
    public void update(Long id, String email, String name) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("User with " + id + " id not found");
        }
        User user = optionalUser.get();

        if (email != null && !email.equals(user.getEmail())) {
            Optional<User> foundByEmail = userRepository.findByEmail(email);
            if (foundByEmail.isPresent()) {
                throw new IllegalStateException("Email already exist");
            }
            user.setEmail(email);
        }
        if (name != null && !name.equals(user.getName())) {
            user.setName(name);
        }
        //userRepository.save(user);
    }
}