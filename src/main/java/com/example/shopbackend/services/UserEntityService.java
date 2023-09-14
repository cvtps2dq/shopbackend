package com.example.shopbackend.services;


import com.example.shopbackend.DTO.GameDTO;
import com.example.shopbackend.DTO.UserGameBondDTO;
import com.example.shopbackend.DTO.UserEntityDTO;
import com.example.shopbackend.mappers.GameMapper;
import com.example.shopbackend.mappers.UserEntityMapper;
import com.example.shopbackend.models.Game;
import com.example.shopbackend.models.Market;
import com.example.shopbackend.models.UserEntity;
import com.example.shopbackend.repositories.GameRepository;
import com.example.shopbackend.repositories.UserEntityRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userMapper;
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final GameService gameService;

    public UserEntityService(UserEntityRepository userEntityRepository, UserEntityMapper userMapper, GameRepository gameRepository, GameMapper gameMapper, GameService gameService) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
        this.gameService = gameService;
    }

    public Iterable<UserEntityDTO> getAll() {

        return userEntityRepository.findAll()
                .stream()
                .map(userMapper::toDTO).
                collect(Collectors.toList());
    }

    public UserEntityDTO getUserEntityById(int id) {
        if (userEntityRepository.findById(id).isPresent())
            return userMapper.toDTO(userEntityRepository.findById(id).get());
        else
            throw new IllegalArgumentException("no such user");
    }

    public UserEntityDTO getUserEntityByNickname(String nickname) {
        return userMapper.toDTO(userEntityRepository.findUserEntityByNickname(nickname));
    }

    public UserEntityDTO saveUserEntity(UserEntityDTO userEntity) {
        return userMapper.toDTO(userEntityRepository.save(userMapper.toEntity(userEntity)));
    }

    public UserEntityDTO editUserEntity(UserEntityDTO updatedUserEntity, int id) {
        return userEntityRepository.findById(id)
                .map(userEntity -> {
                    userEntity.setRegDate(updatedUserEntity.getRegDate());
                    userEntity.setEmail(updatedUserEntity.getEmail());
                    userEntity.setNickname(updatedUserEntity.getNickname());
                    userEntity.setPassword(updatedUserEntity.getPassword());
                    return  userMapper.toDTO(userEntityRepository.save(userEntity));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update user: no such user"));
    }

    public void deleteUserEntity(int id) {
        userEntityRepository.deleteById(id);
    }

    public UserGameBondDTO addGame(UserGameBondDTO purchase){
        UserEntity user = userEntityRepository.findUserEntityByNickname(purchase.getUser().getNickname());
        Game game = gameRepository.findGameByName(purchase.getGame().getName());
        List<GameDTO> games = gameService.getGamesByUserId(user.getId());
        for (GameDTO gameT: games
             ) {
            if(gameT.getName().equals(game.getName())){
                throw new EntityExistsException("user have the game already. can't buy twice!");
            }
        }
        game.getMarketEntities().add(new Market(game, user));

        gameRepository.save(game);
        return new UserGameBondDTO(userMapper.toDTO(user),gameMapper.toDTO(game));
    }
}
