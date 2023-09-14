package com.example.shopbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class ReviewEntity extends BaseEntity {
    @ManyToOne(optional = false)
    private UserEntity userEntity;
    @ManyToOne(optional = false)
    private Game game;
    private String text;
    private String author;
    private Double rating;
    private LocalDate sentDate;

    protected ReviewEntity() {
    }

    public ReviewEntity(UserEntity userEntity, Game game, String text, String author, Double rating, LocalDate sentDate) {
        this.userEntity = userEntity;
        this.game = game;
        this.text = text;
        this.author = author;
        this.rating = rating;
        this.sentDate = sentDate;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public Game getGame() {
        return game;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public Double getRating() {
        return rating;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }
}
