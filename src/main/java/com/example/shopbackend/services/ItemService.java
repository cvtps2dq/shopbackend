package com.example.shopbackend.services;


import com.example.shopbackend.DTO.ItemDTO;
import com.example.shopbackend.DTO.UserGameBondDTO;
import com.example.shopbackend.mappers.ItemMapper;
import com.example.shopbackend.models.Game;
import com.example.shopbackend.models.Item;
import com.example.shopbackend.repositories.GameRepository;
import com.example.shopbackend.repositories.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final GameRepository gameRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, GameRepository gameRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.gameRepository = gameRepository;
        this.itemMapper = itemMapper;
    }


    public Iterable<ItemDTO> getAll() {

        return itemRepository.findAll()
                .stream().map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ItemDTO getItemById(int id) {
        if (itemRepository.findById(id).isPresent())
            return  itemMapper.toDTO(itemRepository.findById(id).get());
        else
            throw new IllegalArgumentException("no such item");
    }

    public ItemDTO getItemByName(String name) {
        return itemMapper.toDTO(itemRepository.findItemByName(name));
    }

    public ItemDTO saveItem(ItemDTO item) {

        Item temp = itemMapper.toEntity(item);
        Game game = gameRepository.findById(item.getGameId()).
                orElseThrow(EntityNotFoundException::new);

        temp.setGame(game);
        temp.setId(null); //magic (not magic - just an id relocation in order to preserve old items)

        return itemMapper.toDTO(itemRepository.save(temp));
    }

    public ItemDTO editItem(ItemDTO updatedItem, int id) {
        return itemMapper.toDTO(itemRepository.findById(id)
                .map(item -> {
                    item.setQuality(updatedItem.getQuality());
                    item.setDesc(updatedItem.getDescription());
                    item.setName(updatedItem.getName());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new IllegalArgumentException("Can't update item: no such item")));
    }

    public List<ItemDTO> getItemsByGameGenreAndUserName(UserGameBondDTO bond){
        String nickname = bond.getUser().getNickname();
        String genre = bond.getGame().getGenre();

        return itemRepository.findItemByGenreAndUserName(genre, nickname)
                .stream()
                .map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
