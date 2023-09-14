package com.example.shopbackend.controllers;


import com.example.shopbackend.DTO.GameDTO;
import com.example.shopbackend.DTO.ReviewEntityDTO;
import com.example.shopbackend.mappers.GameMapper;
import com.example.shopbackend.services.GameService;
import com.example.shopbackend.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/game")
public class GameController {

    private final GameService gameService;
    private final UserEntityService userService;
    private final GameMapper gameMapper;

    @Autowired
    public GameController(GameService gameService, UserEntityService userService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.userService = userService;
        this.gameMapper = gameMapper;
    }


    @GetMapping("/list")
    public Iterable<GameDTO> getAllGame() {

        return gameService.getAll();

    }

    @GetMapping("/{id}")
    public GameDTO getGameById(@PathVariable int id) {

        return gameService.getGameById(id);
    }

    @GetMapping("/name")
    public GameDTO getGameByName(@RequestBody GameDTO game) {
        System.out.println(game);
        return gameService.getGameByName(game);
    }

    @GetMapping("/user/{userId}")
    public Iterable<GameDTO> getGamesByUserId(@PathVariable Integer userId) {

        return gameService.getGamesByUserId(userId);
    }

    @PostMapping("/add")
    public GameDTO addGame(@RequestBody GameDTO game) {
        return gameService.saveGame(game);
    }

    @PutMapping("/{id}")
    public GameDTO updateGame(@PathVariable int id, @RequestBody GameDTO game) {
        return gameService.editGame(game, id);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable int id) {

        gameService.deleteGame(id);
    }

    @GetMapping("/findReview/{nickname}")
    public Iterable<GameDTO> findGamesByUserReview(@PathVariable String nickname){
        return gameService.findGamesByUserReview(nickname);
    }
}