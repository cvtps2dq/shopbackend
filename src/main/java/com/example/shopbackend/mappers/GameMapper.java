package com.example.shopbackend.mappers;

import com.example.shopbackend.DTO.GameDTO;
import com.example.shopbackend.models.Game;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    private final ModelMapper gameMap;

    @Autowired
    public GameMapper(ModelMapper gameMap) {
        this.gameMap = gameMap;
    }

    public GameDTO toDTO (Game input){
        return gameMap.map(input, GameDTO.class);
    }

    public Game toEntity (GameDTO input){
        return gameMap.map(input, Game.class);
    }
}
