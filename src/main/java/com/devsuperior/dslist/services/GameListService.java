package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository repository;

    public List<GameListDTO> findAll(){
        List<GameListDTO> result = repository.findAll().stream().map(x -> new GameListDTO(x)).toList();
        return result;
    }
}
