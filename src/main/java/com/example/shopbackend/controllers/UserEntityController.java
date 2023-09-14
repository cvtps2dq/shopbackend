package com.example.shopbackend.controllers;


import com.example.shopbackend.DTO.UserGameBondDTO;
import com.example.shopbackend.DTO.UserEntityDTO;
import com.example.shopbackend.models.UserEntity;
import com.example.shopbackend.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserEntityController {

    private final UserEntityService userEntityService;

    @Autowired
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/list")
    public Iterable<UserEntityDTO> getAllUsers() {

        return userEntityService.getAll();

    }

    @PostMapping("/buy")
    public UserGameBondDTO addGame(@RequestBody UserGameBondDTO purchase){
        return userEntityService.addGame(purchase);
    }

    @GetMapping("/{id}")
    public UserEntityDTO getUserById(@PathVariable int id) {
        return userEntityService.getUserEntityById(id);
    }

    @GetMapping("/nickname/{nickname}")
    public UserEntityDTO getUserByNickname(@PathVariable String nickname) {
        return userEntityService.getUserEntityByNickname(nickname);
    }

    @PostMapping("/add")
    public UserEntityDTO addUser(@RequestBody UserEntityDTO userEntity) {
        return userEntityService.saveUserEntity(userEntity);
    }

    @PutMapping("/{id}")
    public UserEntityDTO updateUser(@PathVariable int id, @RequestBody UserEntityDTO userEntity) {
        return userEntityService.editUserEntity(userEntity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userEntityService.deleteUserEntity(id);
    }
}