package com.example.shopbackend.repositories;


import com.example.shopbackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository <Game, Integer>{

    public Game findGameByName(String name);

}
