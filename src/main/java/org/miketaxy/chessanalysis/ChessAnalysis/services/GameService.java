package org.miketaxy.chessanalysis.ChessAnalysis.services;

import org.miketaxy.chessanalysis.ChessAnalysis.entity.Game;
import org.springframework.web.bind.annotation.RequestParam;

public interface GameService {
    Game submitGame(@RequestParam("pgn") String pgn);
}
