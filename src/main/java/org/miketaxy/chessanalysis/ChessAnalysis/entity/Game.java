package org.miketaxy.chessanalysis.ChessAnalysis.entity;

import lombok.*;
import org.miketaxy.chessanalysis.ChessAnalysis.chess.PGN;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private int id;
    private PGN pgn;

}
