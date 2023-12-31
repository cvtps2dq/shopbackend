package com.example.shopbackend.repositories;


import com.example.shopbackend.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository <UserEntity, Integer>{
    public UserEntity findUserEntityByNickname(String nickname);
}
