package com.example.shopbackend.controllers;


import com.example.shopbackend.DTO.ReviewEntityDTO;
import com.example.shopbackend.DTO.UserReviewBondDTO;
import com.example.shopbackend.models.ReviewEntity;
import com.example.shopbackend.models.UserEntity;
import com.example.shopbackend.services.GameService;
import com.example.shopbackend.services.ItemService;
import com.example.shopbackend.services.ReviewEntityService;
import com.example.shopbackend.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewEntityController {

    private final GameService gameService;

    private final UserEntityService userEntityService;

    private final ItemService itemService;

    private final ReviewEntityService reviewEntityService;

    @Autowired
    public ReviewEntityController(GameService gameService, UserEntityService userEntityService, ItemService itemService, ReviewEntityService reviewEntityService) {
        this.gameService = gameService;
        this.userEntityService = userEntityService;
        this.itemService = itemService;
        this.reviewEntityService = reviewEntityService;
    }


    @GetMapping
    public Iterable<ReviewEntityDTO> getAllReviews() {
        return reviewEntityService.getAll();
    }

    @GetMapping("/{id}")
    public ReviewEntityDTO getReviewById(@PathVariable int id) {

        return reviewEntityService.getReviewById(id);
    }

    @GetMapping("/author/{author}")
    public ReviewEntityDTO getReviewByAuthor(@PathVariable String author) {
        return reviewEntityService.getUserEntityByAuthor(author);
    }

    @PostMapping
    public ReviewEntityDTO addReview(@RequestBody ReviewEntityDTO reviewEntity) {
        return reviewEntityService.saveReview(reviewEntity);
    }

    @GetMapping("/reviewDateUser")
    public List<ReviewEntityDTO> getReviewsByUserAndDate(@RequestBody UserReviewBondDTO bond) {
        System.out.println(bond.getUser().getNickname() + " " + bond.getReview().getSentDate());
        return reviewEntityService.getUserReviewsByDate(bond);
    }


    @PutMapping("/{id}")
    public ReviewEntityDTO updateReview(@PathVariable int id, @RequestBody ReviewEntityDTO reviewEntity) {
        return reviewEntityService.editReviewEntity(reviewEntity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewEntityService.deleteReviewEntity(id);
    }
}
