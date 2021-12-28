package com.findsquad.api.FindSquad_API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(path = "/findsquad_api/status")
    public String check(){
        return "online";
    }
}
