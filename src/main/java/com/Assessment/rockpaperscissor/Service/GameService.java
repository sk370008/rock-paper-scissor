package com.Assessment.rockpaperscissor.Service;

import com.Assessment.rockpaperscissor.Controller.GameController;
import com.Assessment.rockpaperscissor.Entity.Records;
import com.Assessment.rockpaperscissor.Repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    public Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    GameRepository gameRepository;

    public String winner(String playerMove) {
        //computer move
        String computerMove = generateComputerMove();

        //To save player move, computer move and result of the game in records
        Records records = new Records();
        records.setPlayerMove(playerMove);
        records.setComputerMove(computerMove);

        String message = "";

        String winner = "";
        //logic for winner of the game
        if (playerMove.equalsIgnoreCase("rock") && computerMove.equals("paper")){
            winner = "Computer";
            message = winner + " wins";
            records.setWinner("Computer");
        }else if (playerMove.equalsIgnoreCase("paper") && computerMove.equals("rock")){
            winner = "Player";
            message = winner + " wins";
            records.setWinner("Player");
        }

        if (playerMove.equalsIgnoreCase("rock") && computerMove.equals("scissor")){
            winner = "Player";
            message = winner + " wins";
            records.setWinner("Player");
        }else if (playerMove.equalsIgnoreCase("scissor") && computerMove.equals("rock")){
            winner = "Computer";
            message = winner + " wins";
            records.setWinner("Computer");
        }

        if (playerMove.equalsIgnoreCase("paper") && computerMove.equals("scissor")){
            winner = "Computer";
            message = winner + " wins";
            records.setWinner("Computer");
        }else if (playerMove.equalsIgnoreCase("scissor") && computerMove.equals("paper")){
            winner = "Player";
            message = winner + " wins";
            records.setWinner("Player");
        }

        //logic for if game results in tie
        if (playerMove.equalsIgnoreCase("rock") && computerMove.equals("rock")){
            message = "It is a tie";
            records.setWinner("Tie");
        } else if (playerMove.equalsIgnoreCase("paper") && computerMove.equals("paper")) {
            message = "It is a tie";
            records.setWinner("Tie");
        } else if (playerMove.equalsIgnoreCase("scissor") && computerMove.equals("scissor")) {
            message = "It is a tie";
            records.setWinner("Tie");
        }

        if (message.length()==0)
            records.setWinner("Invalid input");
        //saved in db
        gameRepository.save(records);


        //for logs
        logs(playerMove,computerMove,message);


        if (message.length()>0){
            return message;
        }else {

            return "Incorrect Input " + playerMove;
        }


    }

    public String generateComputerMove(){
        int val = (int) (Math.random() * 3 + 1);

        if (val == 1){
            return "rock";
        } else if (val == 2) {
            return "paper";
        }else if (val == 3){
            return "scissor";
        }
        return "";
    }

    public void logs(String playerMove, String computerMove,String message){
        if(message.length() > 0) {
            logger.info("This is player move: " + playerMove);
            logger.info("This is computer move: " + computerMove);
            logger.info("Result: " + message);
        }else {
            logger.info("Invalid input by player");
        }

    }


}
