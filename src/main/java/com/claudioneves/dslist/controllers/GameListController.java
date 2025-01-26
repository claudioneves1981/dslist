package com.claudioneves.dslist.controllers;

import com.claudioneves.dslist.dto.GameDTO;
import com.claudioneves.dslist.dto.GameListDTO;
import com.claudioneves.dslist.dto.GameMinDTO;
import com.claudioneves.dslist.dto.ReplacementDTO;
import com.claudioneves.dslist.services.GameListService;
import com.claudioneves.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ModelAndView findAll(@ModelAttribute("alertMessage") @Nullable String alertMessage , RedirectAttributes redirectAttributes){
        List<GameListDTO> gameListDTOList = gameListService.findAll();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("gameListDTOList", gameListDTOList);
        return mv;
    }

    @GetMapping(value = "/{listId}/games")
    public ModelAndView findByList(@ModelAttribute("alertMessage") @Nullable String alertMessage , RedirectAttributes redirectAttributes, @PathVariable Long listId){

        ModelAndView mv = new ModelAndView("game-index");
        ModelAndView mvaux = modelAndViewListAux(mv, listId);
        mvaux.addObject("alertMessage", alertMessage);
        redirectAttributes.addFlashAttribute("id", listId);
        return mvaux;
    }

    //@PostMapping(value = "/{listId}/replacement")
    //public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
    //    gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    // }


    public ModelAndView modelAndViewListAux(ModelAndView mv, Long listId){
        List<GameMinDTO> gameMinDTOList = gameService.findByList(listId);
        mv.addObject("gameDTOList", gameMinDTOList);
        return mv;
    }

}
