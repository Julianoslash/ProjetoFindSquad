package com.findsquad.api.FindSquad_API.controller;

import com.findsquad.api.FindSquad_API.model.PartyModel;
import com.findsquad.api.FindSquad_API.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/findsquad_api/party")
public class PartyController {

    @Autowired
    private PartyRepository partyRepository;

    @GetMapping(path = "/findAll")
    private List findAll(){
        return (List) partyRepository.findAll();
    }

    @GetMapping(path = "/findById/{id}")
    private ResponseEntity findById(@PathVariable("id") Long id){
        return partyRepository.findById(id).map(record -> {
            return ResponseEntity.ok().body(record);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/save")
    private PartyModel save(@RequestBody PartyModel game){
        return partyRepository.save(game);
    }

    @PostMapping(path = "/update/{id}")
    private ResponseEntity update(@PathVariable("id") Long id, @RequestBody PartyModel partyUpdate){
        return partyRepository.findById(id).map(record -> {
            if(partyUpdate.getDescription() != null){
                record.setDescription(partyUpdate.getDescription());
            }

            if(partyUpdate.getGameId() != null){
                record.setGameId(partyUpdate.getGameId());
            }

            if(partyUpdate.getPlayersQtd() != null){
                record.setPlayersQtd(partyUpdate.getPlayersQtd());
            }

            PartyModel update = partyRepository.save(record);

            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") Long id){
        return partyRepository.findById(id).map(record -> {
            partyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }


}
