package com.Assessment.rockpaperscissor.Controller;

import com.Assessment.rockpaperscissor.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;


    @GetMapping("/winner")
    public ResponseEntity<String> gameWinner(@RequestParam String playerMove){
        String finalMessage = gameService.winner(playerMove);
        return new ResponseEntity<>(finalMessage, HttpStatus.OK);
    }
}
