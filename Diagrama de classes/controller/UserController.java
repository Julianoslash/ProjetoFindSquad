package com.findsquad.api.FindSquad_API.controller;

import com.findsquad.api.FindSquad_API.model.UserModel;
import com.findsquad.api.FindSquad_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/findsquad_api/users")
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/findAll")
    private List findAll(){
        return (List) userRepository.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    private ResponseEntity findById(@PathVariable("id") Long id){
        return userRepository.findById(id).map(record -> {
            return ResponseEntity.ok().body(record);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/save")
    private UserModel save(@RequestBody UserModel user){
        return userRepository.save(user);
    }

    @PostMapping(path = "/update/{id}")
    private ResponseEntity update(@PathVariable("id") Long id, @RequestBody UserModel userUpdate){
        return userRepository.findById(id).map(record -> {
            if(userUpdate.getName() != null){
                record.setName(userUpdate.getName());
            }

            if(userUpdate.getEmail() != null){
                record.setEmail(userUpdate.getEmail());
            }

            if(userUpdate.getPassword() != null){
                record.setPassword(userUpdate.getPassword());
            }

            UserModel update = userRepository.save(record);

            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") Long id){
        return userRepository.findById(id).map(record -> {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
