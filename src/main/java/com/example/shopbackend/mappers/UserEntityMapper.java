package com.example.shopbackend.mappers;

import com.example.shopbackend.DTO.UserEntityDTO;
import com.example.shopbackend.models.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserEntityMapper {

    private final ModelMapper userMap;

    public UserEntityDTO toDTO (UserEntity user){
        return userMap.map(user, UserEntityDTO.class);
    }

    public UserEntity toEntity (UserEntityDTO user){
        return userMap.map(user, UserEntity.class);
    }
    @Autowired
    public UserEntityMapper(ModelMapper userMap) {
        this.userMap = userMap;
    }
}
