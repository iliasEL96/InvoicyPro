package com.InvoicifyPro.InvoicifyPro.controller;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.UserDTO;
import com.InvoicifyPro.InvoicifyPro.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public UserDTO createUser (@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
