package com.example.shopbackend.init;

import com.example.shopbackend.DTO.GameDTO;
import com.example.shopbackend.DTO.ItemDTO;
import com.example.shopbackend.DTO.ReviewEntityDTO;
import com.example.shopbackend.DTO.UserEntityDTO;
import com.example.shopbackend.services.GameService;
import com.example.shopbackend.services.ItemService;
import com.example.shopbackend.services.ReviewEntityService;
import com.example.shopbackend.services.UserEntityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Component
public class CommandRunnerImpl implements CommandLineRunner {
    private final GameService gameService;
    private final UserEntityService userService;
    private final ItemService itemService;
    private final ReviewEntityService reviewService;

    public CommandRunnerImpl(GameService gameService, UserEntityService userService, ItemService itemService, ReviewEntityService reviewService) {
        this.gameService = gameService;
        this.userService = userService;
        this.itemService = itemService;
        this.reviewService = reviewService;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");
        GameDTO WarThunder = new GameDTO("War Thunder","Компьютерная многопользовательская онлайн-игра с элементами симулятора," +
                " посвящённая боевой авиации, боевым вертолётам, бронетехнике и флоту довоенного периода.",0.0,"Military Battles", new ArrayList<>());

        UserEntityDTO cvtps2dq = new UserEntityDTO("cvtps2dq@gmail.com", "12345","cvtps2dq", new Date());
        ItemDTO T55AM1 = new ItemDTO("T55AM1 Premium Tank","Soviet MBT Tank with great survivability", 1,1);

        ReviewEntityDTO testReview = new ReviewEntityDTO("The game is good","cvtps2dq",10.0, LocalDate.of(2019, 4, 15), 1, 1, 0);

        gameService.saveGame(WarThunder);
        userService.saveUserEntity(cvtps2dq);
        reviewService.saveReview(testReview);
        itemService.saveItem(T55AM1);
    }

}
