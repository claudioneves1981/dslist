package com.claudioneves.dslist.controllers;

import com.claudioneves.dslist.dto.GameDTO;
import com.claudioneves.dslist.dto.GameListDTO;
import com.claudioneves.dslist.dto.GameMinDTO;
import com.claudioneves.dslist.dto.ReplacementDTO;
import com.claudioneves.dslist.services.GameListService;
import com.claudioneves.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }



}
