package com.example.shopbackend.repositories;


import com.example.shopbackend.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer>{
    Item findItemByName(String name);

    @Query("SELECT i " +
            "FROM Item i " +
            "JOIN i.game g " +
            "JOIN g.marketEntities m " +
            "WHERE m.user.nickname = :name AND g.genre = :genre")
    List<Item> findItemByGenreAndUserName(String genre, String name);

}
