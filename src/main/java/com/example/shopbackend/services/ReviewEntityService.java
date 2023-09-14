package com.example.shopbackend.services;


import com.example.shopbackend.DTO.ReviewEntityDTO;
import com.example.shopbackend.DTO.UserReviewBondDTO;
import com.example.shopbackend.mappers.ReviewEntityMapper;
import com.example.shopbackend.models.Game;
import com.example.shopbackend.models.ReviewEntity;
import com.example.shopbackend.models.UserEntity;
import com.example.shopbackend.repositories.GameRepository;
import com.example.shopbackend.repositories.ReviewEntityRepository;
import com.example.shopbackend.repositories.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ReviewEntityService {

    private final ReviewEntityRepository reviewEntityRepository;
    private final GameRepository gameRepository;
    private final UserEntityRepository userRepository;
    private final ReviewEntityMapper reviewMapper;


    public ReviewEntityService(ReviewEntityRepository reviewEntityRepository, GameRepository gameRepository, UserEntityRepository userRepository, ReviewEntityMapper reviewMapper) {
        this.reviewEntityRepository = reviewEntityRepository;
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewEntityDTO> getAll() {

        return reviewEntityRepository.findAll()
                .stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ReviewEntityDTO getReviewById(int id) {
        if (reviewEntityRepository.findById(id).isPresent())
            return reviewMapper.toDTO(reviewEntityRepository.findById(id).get());
        else
            throw new IllegalArgumentException("no such review");
    }

    public ReviewEntityDTO getUserEntityByAuthor(String author) {
        return reviewMapper.toDTO(reviewEntityRepository.findReviewEntityByAuthor(author));
    }

    public ReviewEntityDTO saveReview(ReviewEntityDTO reviewEntity) {

        ReviewEntity temp = reviewMapper.toEntity(reviewEntity);
        Game game = gameRepository.findById(reviewEntity.getGameId()).
                orElseThrow(EntityNotFoundException::new);
        UserEntity user = userRepository.findById(reviewEntity.getUserId()).
                orElseThrow(EntityNotFoundException::new);

        temp.setGame(game);
        temp.setUser(user);

        return  reviewMapper.toDTO(reviewEntityRepository.save(temp));

    }

    public ReviewEntityDTO editReviewEntity(ReviewEntityDTO updatedReviewEntity, int id) {
        return reviewEntityRepository.findById(id)
                .map(reviewEntity -> {
                    reviewEntity.setRating(updatedReviewEntity.getRating());
                    reviewEntity.setSentDate(updatedReviewEntity.getSentDate());
                    reviewEntity.setAuthor(updatedReviewEntity.getAuthor());
                    reviewEntity.setText(updatedReviewEntity.getText());
                    return reviewMapper.toDTO(reviewEntityRepository.save(reviewEntity));
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update review: no such review"));
    }

    public void deleteReviewEntity(int id) {
        reviewEntityRepository.deleteById(id);
    }

    public List<ReviewEntityDTO> getUserReviewsByDate (UserReviewBondDTO bond){
        String nickname = bond.getUser().getNickname();
        LocalDate date = bond.getReview().getSentDate();
        return reviewEntityRepository.findReviewsByUserAndDate(nickname, date)
                .stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }
}
