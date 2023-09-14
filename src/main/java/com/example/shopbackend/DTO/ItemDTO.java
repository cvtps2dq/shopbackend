package com.example.shopbackend.DTO;

public class ItemDTO {
    private String name;
    private String description;
    private Integer quality;

    private Integer gameId;

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

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public ItemDTO(String name, String description, Integer quality, Integer gameId) {
        this.name = name;
        this.description = description;
        this.quality = quality;
        this.gameId = gameId;
    }

    public ItemDTO() {
    }
}
