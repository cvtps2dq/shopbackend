package com.example.shopbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Market extends BaseEntity{
    @ManyToOne
    private Game game;

    @ManyToOne
    private UserEntity user;

    public Market() {
    }

    public Market(Game game, UserEntity user) {
        this.game = game;
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
