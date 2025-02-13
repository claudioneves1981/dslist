package com.claudioneves.dslist.services;

import com.claudioneves.dslist.dto.GameListDTO;
import com.claudioneves.dslist.entities.GameList;
import com.claudioneves.dslist.projections.GameMinProjection;
import com.claudioneves.dslist.repositories.GameListRepository;
import com.claudioneves.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {


    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
       List<GameList> result =  gameListRepository.findAll();
       return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list =  gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for(int i = min; i <=max; i++) {
           gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
