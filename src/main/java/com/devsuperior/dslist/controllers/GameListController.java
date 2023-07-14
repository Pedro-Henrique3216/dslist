package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService service;

    @Autowired
    GameService gameservice;

    @GetMapping
    public List<GameListDTO> findAll(){
        var result = service.findAll();
        return result;
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> findByLit(@PathVariable Long id){
        var result = gameservice.findByList(id);
        return result;
    }

    @PutMapping(value = "/{id}/replacement")
    public void remote(@PathVariable Long id, @RequestBody ReplacementDTO dto){
        service.move(id, dto.getSourceIndex(), dto.getDestinationIndex());
    }
}
