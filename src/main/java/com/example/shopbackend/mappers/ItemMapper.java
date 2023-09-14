package com.example.shopbackend.mappers;

import com.example.shopbackend.DTO.ItemDTO;
import com.example.shopbackend.models.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private final ModelMapper itemMap;

    @Autowired
    public ItemMapper(ModelMapper itemMap) {
        this.itemMap = itemMap;
    }

    public ItemDTO toDTO (Item input){
        return itemMap.map(input, ItemDTO.class);
    }

    public Item toEntity (ItemDTO input){
        return itemMap.map(input, Item.class);
    }
}
