package com.app.twitterClone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/twit")
public class TwitController {

    @GetMapping("/listar")
    public String listar(){

        return "hola";
    }
}
