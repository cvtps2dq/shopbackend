package com.example.shopbackend.DTO;

import java.util.List;

public class GameDTO {
    private String name;
    private String description;
    private Double price;
    private String genre;

    private List<ReviewEntityDTO> reviews;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<ReviewEntityDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntityDTO> reviews) {
        this.reviews = reviews;
    }

    public GameDTO() {
    }

    public GameDTO(String name, String description, Double price, String genre, List<ReviewEntityDTO> reviews) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.reviews = reviews;
    }
}
