package com.example.shopbackend.DTO;


public class UserGameBondDTO {
    private UserEntityDTO user;
    private GameDTO game;

    protected UserGameBondDTO() {
    }

    public UserGameBondDTO(UserEntityDTO user, GameDTO game) {
        this.user = user;
        this.game = game;
    }

    public UserEntityDTO getUser() {
        return user;
    }

    public void setUser(UserEntityDTO user) {
        this.user = user;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }
}
