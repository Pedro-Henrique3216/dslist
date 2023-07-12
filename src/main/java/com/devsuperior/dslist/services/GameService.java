package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        var result = repository.findAll();
        var dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        var result = repository.findById(id).get();
        var dto = new GameDTO(result);

        return dto;
    }

    public List<GameMinDTO> findByList(Long id){
        List<GameMinDTO> result = repository.searchByList(id).stream().map(x -> new GameMinDTO(x)).toList();
        return result;
    }
}
