package com.example.shopbackend.mappers;

import com.example.shopbackend.DTO.ReviewEntityDTO;
import com.example.shopbackend.models.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityMapper {
    private final ModelMapper reviewMap;

    @Autowired
    public ReviewEntityMapper(ModelMapper reviewMap) {
        this.reviewMap = reviewMap;
    }

    public ReviewEntityDTO toDTO (ReviewEntity input){
        return reviewMap.map(input, ReviewEntityDTO.class);
    }

    public ReviewEntity toEntity (ReviewEntityDTO input){
        return reviewMap.map(input, ReviewEntity.class);
    }
}
