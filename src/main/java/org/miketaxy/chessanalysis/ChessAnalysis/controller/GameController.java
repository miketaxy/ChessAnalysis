package org.miketaxy.chessanalysis.ChessAnalysis.controller;

import com.github.bhlangonijr.chesslib.Board;
import com.rahul.stockfish.Stockfish;
import org.miketaxy.chessanalysis.ChessAnalysis.chess.PGN;
import org.miketaxy.chessanalysis.ChessAnalysis.entity.Game;
import org.miketaxy.chessanalysis.ChessAnalysis.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
