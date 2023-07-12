package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        var result = service.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        var result = service.findById(id);
        return result;
    }

}
