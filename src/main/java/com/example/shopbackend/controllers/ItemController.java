package com.example.shopbackend.controllers;


import com.example.shopbackend.DTO.ItemDTO;
import com.example.shopbackend.DTO.UserGameBondDTO;
import com.example.shopbackend.models.Item;
import com.example.shopbackend.services.GameService;
import com.example.shopbackend.services.ItemService;
import com.example.shopbackend.services.ReviewEntityService;
import com.example.shopbackend.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/item")
public class ItemController {

    private final GameService gameService;

    private final UserEntityService userEntityService;

    private final ItemService itemService;

    private final ReviewEntityService reviewEntityService;

    @Autowired
    public ItemController(GameService gameService, UserEntityService userEntityService, ItemService itemService, ReviewEntityService reviewEntityService) {
        this.gameService = gameService;
        this.userEntityService = userEntityService;
        this.itemService = itemService;
        this.reviewEntityService = reviewEntityService;
    }


    @GetMapping("/list")
    public Iterable<ItemDTO> getAllItem() {

        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable int id) {

        return itemService.getItemById(id);
    }

    @GetMapping("/genreUser")
    public Iterable<ItemDTO> getItemsByGameGenreAndUserName(@RequestBody UserGameBondDTO bond) {
        return itemService.getItemsByGameGenreAndUserName(bond);
    }

    @GetMapping("/byname")
    public ItemDTO getItemByName(@RequestBody ItemDTO item) {
        return itemService.getItemByName(item.getName());
    }

    @PostMapping("/add")
    public ItemDTO addItem(@RequestBody ItemDTO item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/{id}")
    public ItemDTO updateItem(@PathVariable int id, @RequestBody ItemDTO item) {
        return itemService.editItem(item, id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }
}