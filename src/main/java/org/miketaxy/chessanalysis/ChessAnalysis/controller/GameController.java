package org.miketaxy.chessanalysis.ChessAnalysis.controller;

import org.miketaxy.chessanalysis.ChessAnalysis.entity.Game;
import org.miketaxy.chessanalysis.ChessAnalysis.services.mapper.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;
    @PostMapping("/submit")
    public Game submitGame(@RequestParam("pgn") String pgn) {
        return gameService.submitGame(pgn);
    }
}
