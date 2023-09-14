package com.example.shopbackend.repositories;


import com.example.shopbackend.models.ReviewEntity;
import com.example.shopbackend.models.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@Repository
public interface ReviewEntityRepository extends JpaRepository <ReviewEntity, Integer>{
    ReviewEntity findReviewEntityByAuthor(String author);

    @Query("SELECT r FROM ReviewEntity r JOIN r.userEntity u WHERE u.nickname = :nickname ")
    List<ReviewEntity> findAllByUser(String nickname);


    @Query("SELECT r FROM ReviewEntity r JOIN r.userEntity u WHERE u.nickname = :nickname AND r.sentDate = :date")
    List<ReviewEntity> findReviewsByUserAndDate(String nickname, LocalDate date);
}
