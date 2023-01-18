package com.loginAuthentication.controller;

import com.loginAuthentication.user.DataListUser;
import com.loginAuthentication.user.DataCreateUser;
import com.loginAuthentication.user.User;
import com.loginAuthentication.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {
    @Autowired
    private UserRepository repository;


    @PostMapping
    @Transactional
    @ResponseBody
        public void createUser(@RequestBody @Valid DataCreateUser dataCreateUser) throws Exception {
        try{
            repository.save(new User(dataCreateUser));
        } catch (Exception e){
            throw new LoginException("Maybe something happened");
        }
    }
    @GetMapping("/{id}")
    public DataListUser findById(@PathVariable Long id){
        return repository.findAllById(id);
    }

    @GetMapping("")
    public List<User> findAll(){
        return repository.findAll();
    }
}
