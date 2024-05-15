package com.julioceno.workshopspringbootmongodb.services;

import com.julioceno.workshopspringbootmongodb.domain.User;
import com.julioceno.workshopspringbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
