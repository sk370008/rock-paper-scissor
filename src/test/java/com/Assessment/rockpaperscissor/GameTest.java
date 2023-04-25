package com.Assessment.rockpaperscissor;

import com.Assessment.rockpaperscissor.Service.GameService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    @Test
    public void testRandomMoveGenerator() {
        GameService gameService = new GameService();
        String randomMove = gameService.generateComputerMove();
        List<String> validMoves = Arrays.asList("rock","paper","scissor");
        assertTrue(validMoves.contains(randomMove));
    }

}
