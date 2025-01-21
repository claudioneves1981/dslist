package com.claudioneves.dslist.services;

import com.claudioneves.dslist.dto.GameMinDTO;
import com.claudioneves.dslist.entities.Game;
import com.claudioneves.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {


    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){

       List<Game> result =  gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();

    }
}
