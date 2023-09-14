package com.example.shopbackend.DTO;

import java.time.LocalDate;
import java.util.Date;

public class ReviewEntityDTO {
    private String text;
    private String author;
    private Double rating;
    private LocalDate sentDate;
    private Integer gameId;
    private Integer userId;

    private Integer id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReviewEntityDTO(String text, String author, Double rating, LocalDate sentDate, Integer gameId, Integer userId, Integer id) {
        this.text = text;
        this.author = author;
        this.rating = rating;
        this.sentDate = sentDate;
        this.gameId = gameId;
        this.userId = userId;
        this.id = id;
    }

    public ReviewEntityDTO() {
    }

}
