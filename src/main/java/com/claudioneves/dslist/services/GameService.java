package com.claudioneves.dslist.services;

import com.claudioneves.dslist.dto.GameDTO;
import com.claudioneves.dslist.dto.GameMinDTO;
import com.claudioneves.dslist.entities.Game;
import com.claudioneves.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {


    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
       List<Game> result =  gameRepository.findAll();
       return result.stream().map(GameMinDTO::new).toList();
    }
}
