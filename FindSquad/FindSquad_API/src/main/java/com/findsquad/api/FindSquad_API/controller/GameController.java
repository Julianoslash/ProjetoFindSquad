package com.findsquad.api.FindSquad_API.controller;

import com.findsquad.api.FindSquad_API.model.GameModel;
import com.findsquad.api.FindSquad_API.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/findsquad_api/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping(path = "/findAll")
    private List findAll(){
        return (List) gameRepository.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    private ResponseEntity findById(@PathVariable("id") Long id){
        return gameRepository.findById(id).map(record -> {
            return ResponseEntity.ok().body(record);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/save")
    private GameModel save(@RequestBody GameModel game){
        return gameRepository.save(game);
    }

    @PostMapping(path = "/update/{id}")
    private ResponseEntity update(@PathVariable("id") Long id, @RequestBody GameModel gameUpdate){
        return gameRepository.findById(id).map(record -> {
            if(gameUpdate.getName() != null){
                record.setName(gameUpdate.getName());
            }

            if(gameUpdate.getGender() != null){
                record.setGender(gameUpdate.getGender());
            }

            if(gameUpdate.getImage() != null){
                record.setImage(gameUpdate.getImage());
            }

            if(gameUpdate.getDescription() != null){
                record.setDescription(gameUpdate.getDescription());
            }

            GameModel update = gameRepository.save(record);

            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") Long id){
        return gameRepository.findById(id).map(record -> {
            gameRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
