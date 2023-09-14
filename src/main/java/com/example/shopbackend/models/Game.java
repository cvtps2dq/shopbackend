package com.example.shopbackend.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Game extends BaseEntity {
    @OneToMany(mappedBy = "game", targetEntity = ReviewEntity.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Set <ReviewEntity> reviews;
    @OneToMany(mappedBy = "game", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Set <Market> marketEntities;
    @OneToMany(mappedBy = "game", targetEntity = Item.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Set <Item> itemEntities;
    private String name;
    private String description;
    private Double price;
    private String genre;

    protected Game() {
    }

    public Game(Set<ReviewEntity> reviews, Set<Market> marketEntities, Set<Item> itemEntities, String name, String description, Double price, String genre) {
        this.reviews = reviews;
        this.marketEntities = marketEntities;
        this.itemEntities = itemEntities;
        this.name = name;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }

    public Set<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public Set<Market> getMarketEntities() {
        return marketEntities;
    }

    public void setMarketEntities(Set<Market> marketEntities) {
        this.marketEntities = marketEntities;
    }

    public Set<Item> getItemEntities() {
        return itemEntities;
    }

    public void setItemEntities(Set<Item> itemEntities) {
        this.itemEntities = itemEntities;
    }

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
}
