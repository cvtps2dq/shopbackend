package com.example.shopbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Item extends BaseEntity{
    private String name;
    private String description;
    private Integer quality;
    @ManyToOne(optional = false)
    private Game game;

    protected Item() {
    }

    public Item(String name, String desc, Integer quality, Game game) {
        this.name = name;
        this.description = desc;
        this.quality = quality;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public Integer getQuality() {
        return quality;
    }

    public Game getGame() {
        return game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
