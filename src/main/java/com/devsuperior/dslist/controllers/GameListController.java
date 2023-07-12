package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
