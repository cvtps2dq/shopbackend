package com.example.shopbackend.services;

import com.example.shopbackend.DTO.GameDTO;
import com.example.shopbackend.mappers.GameMapper;
import com.example.shopbackend.models.Market;
import com.example.shopbackend.models.UserEntity;
import com.example.shopbackend.repositories.GameRepository;
import com.example.shopbackend.repositories.ReviewEntityRepository;
import com.example.shopbackend.repositories.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final UserEntityRepository userRepository;
    private final GameMapper gameMapper;
    private final ReviewEntityRepository reviewEntityRepository;

    public GameService(GameRepository gameRepository, UserEntityRepository userRepository, GameMapper gameMapper, ReviewEntityRepository reviewEntityRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.gameMapper = gameMapper;
        this.reviewEntityRepository = reviewEntityRepository;
    }

    public List<GameDTO> getAll() {
        return gameRepository.findAll()
                .stream()
                .map(gameMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GameDTO getGameById(int id) {
        if (gameRepository.findById(id).isPresent())
            return gameMapper.toDTO(gameRepository.findById(id).get());
        else
            throw new IllegalArgumentException("no such game");
    }

    public GameDTO getGameByName(GameDTO game) {

        return gameMapper.toDTO(gameRepository.findGameByName(game.getName()));
    }


    public GameDTO saveGame(GameDTO game) {

        return gameMapper.toDTO(gameRepository.save(gameMapper.toEntity(game)));
    }

    public GameDTO editGame(GameDTO updatedGame, int id) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setPrice(updatedGame.getPrice());
                    game.setName(updatedGame.getName());
                    game.setDescription(updatedGame.getDescription());
                    game.setGenre(updatedGame.getGenre());
                    return  gameMapper.toDTO(gameRepository.save(game));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update game: no such game"));
    }

    public void deleteGame(int id) {

        gameRepository.deleteById(id);
    }

    public List<GameDTO> getGamesByUserId(Integer userId) {

        return userRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new)
                .getGames()
                .stream()
                .map(Market::getGame)
                .map(gameMapper::toDTO)
                .collect(Collectors.toList());

    }

    public List<GameDTO> findGamesByUserReview (String nickname){
        return reviewEntityRepository.findAllByUser(nickname)
                .stream()
                .map(reviewEntity -> gameMapper.toDTO(reviewEntity.getGame()))
                .collect(Collectors.toList());

    }
}
