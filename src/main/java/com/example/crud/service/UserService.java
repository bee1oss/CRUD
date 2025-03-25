package com.example.crud.service;

import com.example.crud.repository.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service
public class UserService {
    public List<User> hello() {
        return List.of(
                new User(1L,"Serega","serega@email.com","passwd", LocalDate.of(1999,5,1), 26),
                new User(2L,"Matvey","matvey@email.com","passwd", LocalDate.of(2002,8,11), 24)
        );
    }
}