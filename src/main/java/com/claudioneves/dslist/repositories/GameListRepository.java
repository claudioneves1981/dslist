package com.claudioneves.dslist.repositories;

import com.claudioneves.dslist.entities.Game;
import com.claudioneves.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {


}
