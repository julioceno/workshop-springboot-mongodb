package com.julioceno.workshopspringbootmongodb.resources;

import com.julioceno.workshopspringbootmongodb.domain.User;
import com.julioceno.workshopspringbootmongodb.dto.UserDTO;
import com.julioceno.workshopspringbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    UserService userService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream()
                .map(item -> new UserDTO(item))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok().body(listDTO);
    }
}