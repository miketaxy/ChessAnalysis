package org.miketaxy.chessanalysis.ChessAnalysis.entity;

import lombok.Getter;
import lombok.Setter;
import org.miketaxy.chessanalysis.ChessAnalysis.chess.PGN;

public class Game {

    private int id;
    @Getter @Setter private PGN pgn;

}
