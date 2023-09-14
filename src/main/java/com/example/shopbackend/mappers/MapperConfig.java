package com.example.shopbackend.mappers;

import com.example.shopbackend.DTO.ReviewEntityDTO;
import com.example.shopbackend.models.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper (){

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        TypeMap<ReviewEntityDTO, ReviewEntity> reviewMapper = modelMapper.createTypeMap
                (ReviewEntityDTO.class, ReviewEntity.class);
        return modelMapper;
    }
}
